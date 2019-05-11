package org.sber.service.testservice.model;

public class Client {
    private String uid;
    private String name;
    private String product;

    public Client() {

    }

    public Client(String uid, String name, String product, int balance) {
        this.uid = uid;
        this.name = name;
        this.product = product;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Client{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
