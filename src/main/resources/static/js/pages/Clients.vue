<template>
    <clients-list :clients="clients"></clients-list>
</template>

<script>
    import ClientsList from 'components\\clients\\ClientsList.vue'

    export default {
        components: {
            ClientsList
        },
        data() {
            return {
                clients: testServiceData.clientsData
            }
        }
    }
</script>

<style>

</style>
