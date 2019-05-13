var serviceApi = Vue.resource('clients-products{/id}');

Vue.component('tuple-list', {
    props: ['tuples'],
    data: function() {
        return {
            tuple: null
        }
    },
    template:
        '<div>' +
        '' +
        '</div>'
});

var app = new Vue({
    el: '#main-app',
    template: '<tuple-list :typel="typel"/>',
    data: {
        tuple: []
    }
});
