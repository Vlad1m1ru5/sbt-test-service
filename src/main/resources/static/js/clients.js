var clientsApi = Vue.resource('clients{/id}');

function getUid(list, uid) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].uid === uid) {
            return i;
        }
    }

    return -1;
}

Vue.component('clients-form', {
    props: ['clients', 'clientInput'],
    data: function() {
        return {
            name: '',
            balance: '',
            uid: ''
        }
    },
    watch: {
        clientInput: function(newInput, oldInput) {
            this.name= newInput.name;
            this.balance = newInput.balance;
            this.uid = newInput.uid;
        }
    },
    template:
        '<div>' +
        '   <input type="text" placeholder="Имя клиента" v-model="name"/>' +
        '   <input type="text" placeholder="Баланс клиента" v-model="balance"/>' +
        '   <input type="button" value="Сохранить" @click="save"/>' +
        '</div>',
    methods: {
        save: function () {
            var input = {
                name: this.name,
                balance: this.balance
            };

            if (this.uid) {
                clientsApi.update({uid: this.uid}, input).then(result =>
                    result.json().then(data => {
                        var index = getUid(this.uid, data.uid);
                        this.clients.splice(index, 1, data);
                        this.name = '';
                        this.uid = '';
                    })
                )
            } else {
                clientsApi.save({}, input).then(result =>
                    result.json().then(data => {
                        this.clients.push(data);
                        this.name = '';
                        this.balance = '';
                    })
                )
            }
        }
    }
});

Vue.component('clients-row', {
    props: ['client', 'editClient'],
    template:
        '<div >' +
        '   {{ client.uid }}   {{ client.name }} {{ client.balance }}' +
        '   <span>' +
        '       <input type="button" value="Изменить" @click="edit"' +
        '       <input type="button" value="Удалить" @click="delete"' +
        '   </span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editClient(this.client);
        },
        delete: function () {
            clientsApi.remove({uid: this.client.uid}).then(result => {
                if (result.ok) {
                    this.client.splice(this.clients.indexOf(this.client), 1);
                }
            })
        }
    }
});

Vue.component('clients-list', {
    props:  ['clients'],
    data: function() {
        return {
            client: null
        }
    },
    template:
        '<div>' +
        '   <clients-form :clients="clients" :clientInput="client"/>' +
        '   <clients-row v-for="client in clients" :key="client.uid" :client="client" :editClient="editClient"/>' +
        '</div>',
    created: function() {
        clientsApi.get().then( result =>
            result.json().then( data =>
                data.forEach(client => this.clients.push(client))
            )
        )
    },
    methods: {
        editClient: function(client) {
            this.client = client;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<clients-list :clients="clients"/>',
    data: {
        clients: []
    }
});
