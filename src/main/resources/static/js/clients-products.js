var clientsProductsApi = Vue.resource('clients-products{/id}');

Vue.component('clients-products-form', {
    props: ['message', 'messageInput'],
    data: function() {
       return {
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
        '   <input type="button" value="Сохранить" @click="save"/>' +
        '</div>'
});

Vue.component('clients-products-list', {
    props: 'messages',
    template:
        '<div>' +
        '   <clients-products-form :messages="messages" :messageInput="message"/>' +
        '   <clients-products-row v-for="message in messages" :key="message.id"' +
        '   :message="message" :editMessage="editMessage" :messages="messages"/>' +
        '</div>',
    created: function () {
        clientsProductsApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message =>
                    this.messages.push(message)
                )
            )
        )
    },
    methods: {
        editMessage: function () {
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