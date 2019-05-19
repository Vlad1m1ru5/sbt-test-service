<template>
    <div>
        <input type="text" placeholder="Имя клиента" v-model="name"/>
        <input type="text" placeholder="Баланс клиента" v-model="balance"/>
        <input type="button" value="Сохранить" @click="save"/>
    </div>
</template>

<script>
    function getUid(list, uid) {
        for (var i = 0; i < list.length; i++) {
            if (list[i].uid === uid) {
                return i
            }
        }

        return -1
    }

    export default {
        props: ['clients', 'clientInput'],
        data() {
            return {
                name: '',
                balance: '',
                uid: ''
            }
        },
        watch: {
            clientInput: function(input, oldInput) {
                this.name= input.name;
                this.balance = input.balance;
                this.uid = input.uid;
            }
        },
        methods: {
            save() {
                const input = {
                    name: this.name,
                    balance: this.balance
                }

                if (this.uid) {
                    this.$resource('clients{/id}').update({id: this.uid}, input).then(result =>
                        result.json().then(data => {
                            const index = getUid(this.clients, data.uid)
                            this.clients.splice(index, 1, data)
                            this.uid = ''
                        })
                    )
                } else {
                    this.$resource('clients{/id}').save({}, input).then(result =>
                        result.json().then(data => {
                            this.clients.push(data)
                        })
                    )
                }

                this.name = ''
                this.balance = ''
            }
        }
    }
</script>

<style>

</style>