<template>
    <clients-list :clients="clients"/>
</template>

<script>
    import ClientsList from 'components/clients/ClietnsList.vue'

    export default {
        components:
            ClientsList,
        data() {
            clients: testServiceData.clientsData
        }
    }
</script>

<style>

</style>
