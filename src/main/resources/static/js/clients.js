
var clientsApi = Vue.resource('clients{/id}');

Vue.component('clients-row', {
    props: ['client'],
    template: '<div >{{ client.id }} {{ client.name }} {{ client.balance }}</div>'
});

Vue.component('clients-list', {
    props:  ['clients'],
    template:
        '<div>' +
            '<clients-row v-for="client in clients" ' +
            ':key="client.id" :client="client"/>' +
        '</div>',
    created: function() {
        clientsApi.get().then( result =>
            result.json().then( data =>
                data.forEach(client => this.clients.push(client))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<clients-list :clients="clients"/>',
    data: {
        clients: []
    }
});
