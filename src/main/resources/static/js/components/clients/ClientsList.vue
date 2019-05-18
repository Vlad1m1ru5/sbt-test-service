<template>
    <div style="position: relative; width: 700px;">
        <clients-form :clients="clients" :clientInput="client"/>
        <clients-row v-for="client in clients"
                     :key="client.uid"
                     :client="client"
                     :editClient="editClient"
                     :deleteClient="deleteClient"
                     :clients="clients"/>
    </div>
</template>

<script>
    import ClientsRow from 'components/clients/ClietnsRow.vue'

    export default {
        props: ['clients'],
        components: {
          ClientsRow
        },
        data() {
            return {
                client: null
            }
        },
        methods: {
            editClient(client) {
                this.client = client
            },
            deleteClient(client) {
                this.$resource('clients{/id}').remove({id: client.uid}).then(result => {
                    if (result.ok) {
                        this.clients.splice(this.clients.indexOf(this.client), 1);
                    }
                })
            }
        }
    }
</script>

<style>

</style>