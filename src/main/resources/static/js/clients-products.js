var clientsProductsApi = Vue.resource('clients-products{/id}');
var clientsApi = Vue.resource('clients');
var productsApi = Vue.resource('products');

Vue.component('clients-products-row', {
    props: ['message', 'messages', 'editMessage'],
    template:
        '<div>' +
        '   {{ message.uid}} {{ message.clientName}} {{message.productName}}' +
        '   <span style="position: absolute; right:0px;">' +
        '       <input type="button" value="Изменить" @click="edit"/>' +
        '       <input type="button" value="Удалмить" @click="del"/>' +
        '   </span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editMessage(this.message);
        },
        del: function() {
            clientsProductsApi.remove({id: this.message.uid}).then( result => {
                if(result.ok){
                    this.messages.splice(this.messages.indexOf(this.message), 1);
                }
            })
        }
    }
});

Vue.component('clients-products-form', {
    props: ['messages', 'messageInput'],
    data: function() {
        return {
            clients: clientsApi.getAll(),
            products: productsApi.getAll(),

            uid: '',
            clientUid: '',
            clientName: '',
            productUid: '',
            productName: ''
        }
    },
    watch: {
        messageInput: function(input, oldInput) {
            this.uid = input.uid;
            this.clientName = input.clientName;
            this.clientUid = input.clientUid;
            this.productName = input.productName;
            this.productUid = input.productUid;
        }
    },
    template:
        '<div>' +
        '   <select v-model="selectedClient">' +
        '       <option v-for="client in clients" v-bind:value="client">{{ client.uid }}</option>' +
        '   </select>' +
        '   <select v-model="selectedProduct">' +
        '       <optin v-for="product in products" v-bind:value="product">{{ product.uid }}</optin>' +
        '   </select>' +
        '   <span> ' +
        '       <input type="button" value="Сохранить" @click="save"/>' +
        '       <input type="button" value="Обновить" @click="update"/>' +
        '   </span>' +
        '</div>',
    methods: {
        save: function() {
            var input = {
                clientName: this.clientName,
                clientUid: this.clientUid,
                productName: this.productName,
                productUid: this.productUid
            };

            if (this.uid) {
                clientsProductsApi.update({id: this.uid}, input).then(result => {
                    result.json().then(data => {
                        var index = getUid(this.messages, data.uid);

                        this.messages.splice(index, 1, data);
                        this.uid = '';
                    })
                })
            } else {
                clientsProductsApi.save({}, input).then(result => {
                    result.json().then(data => {
                        this.messages.push(data);
                    })
                })
            }
        },

        update: function(){
            //TODO
            //  update clients and products values
            //  to get clients and products values
        }
    }
});

Vue.component('clients-products-list', {
    props: ['messages'],
    data: function() {
       return {
           message:null
       }
    },
    template:
        '<div>' +
        '   <clients-products-form :messages="messages" :messageInput="message"/>' +
        '   <clients-products-row v-for="message in messages" :key="message.id"' +
        '   :message="message" :editMessage="editMessage" :messages="messages"/>' +
        '</div>',
    created: function () {
        clientsProductsApi.get().then( result =>
            result.json().then( data =>
                data.forEach(message =>
                    this.messages.push(message)
                )
            )
        )
    },
    methods: {
        editMessage: function (message) {
            this.message = message;
        }
    }
});

var clientsProductsApp = new Vue({
    el:'#clients-products',
    template: '<clients-products-list :messages="messages"/>',
    data: {
        messages: []
    }
});