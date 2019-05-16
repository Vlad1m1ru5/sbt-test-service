var productsApi = Vue.resource('products{/id}');

function getUid(list, uid) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].uid === uid) {
            return i;
        }
    }

    return -1;
}

Vue.component('products-form', {
    props: ['products', 'productInput'],
    data: function() {
        return {
            name: '',
            demand: '',
            uid: ''
        }
    },
    watch: {
        productInput: function(input, oldInput) {
            this.name= input.name;
            this.demand = input.demand;
            this.uid = input.uid;
        }
    },
    template:
        '<div>' +
        '   <input type="text" placeholder="Наименованеи продукта" v-model="name"/>' +
        '   <input type="text" placeholder="Востребованность" v-model="demand"/>' +
        '   <input type="button" value="Сохранить" @click="save"/>' +
        '</div>',
    methods: {
        save: function () {
            var input = {
                name: this.name,
                demand: this.demand
            };

            if (this.uid) {
                productsApi.update({id: this.uid}, input).then(result =>
                    result.json().then(data => {
                        var index = getUid(this.products, data.uid);

                        this.products.splice(index, 1, data);
                        this.uid = '';
                    })
                )
            } else {
                productsApi.save({}, input).then(result =>
                    result.json().then(data => {
                        this.products.push(data);
                    })
                )
            }

            this.name = '';
            this.demand = '';
        }
    }
});

Vue.component('products-row', {
    props: ['product', 'products', 'editProduct'],
    template:
        '<div >' +
        '   {{ product.uid }} {{ product.name }} {{ product.demand }}' +
        '   <span style="position: absolute; right: 0px;">' +
        '       <input type="button" value="Изменить" @click="edit"/>' +
        '       <input type="button" value="Удалить" @click="del"/>' +
        '   </span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editProduct(this.product);
        },
        del: function() {
            productsApi.remove({id: this.product.uid}).then(result => {
                if (result.ok) {
                    this.products.splice(this.products.indexOf(this.product), 1);
                }
            })
        }
    }
});

Vue.component('products-list', {
    props:  ['products'],
    data: function() {
        return {
            product: null
        }
    },
    template:
        '<div style="position: relative; width: 700px;">' +
        '   <products-form :products="products" :productInput="product"/>' +
        '   <products-row v-for="product in products" :key="product.uid" ' +
        '   :product="product" :editProduct="editProduct" :products="products"/>' +
        '</div>',
    created: function() {
        productsApi.get().then(result =>
            result.json().then( data =>
                data.forEach(product =>
                    this.products.push(product))
            )
        )
    },
    methods: {
        editProduct: function(product) {
            this.product = product;
        }
    }
});

var app = new Vue({
    el: '#products',
    template: '<products-list :products="products"/>',
    data: {
        products: []
    }
});
