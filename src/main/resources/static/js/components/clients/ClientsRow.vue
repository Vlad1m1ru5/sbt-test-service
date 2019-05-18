<template>
    <div >
        {{ client.uid }} {{ client.name }} {{ client.balance }}
        <span style="position: absolute; right: 0px;">
            <input type="button" value="Изменить" @click="edit"/>
            <input type="button" value="Удалить" @click="del"/>
        </span>
    </div>
</template>

<script>
    export default {
        props: ['client', 'clients', 'deleteClient', 'editClient'],
        methods: {
            edit() {
                this.editClient(this.client)
            },
            del() {
                this.deleteClient(this.client)
            }
        }
    }
</script>

<style>

</style>
