
Vue.component('messages-row', {
    props: ['message'],
    template: '<div><i>({{message.id}})</i> {{message.text}}</div>'
});

Vue.component('messages-list', {
    props:  ['messages'],
    template: '<div><messages-row v-for="message in messages" :message="message"/></div>'
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages"/>',
    data: {
        messages: [
            {id: '123', text: "Что-то"},
            {id: '3', text: "Здесь"},
            {id: '12', text: "Написано"}
        ]
    }
});