package org.sber.service.testservice.model;

import javax.persistence.*;

@Entity
@Table
public class ClientProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String clientUid;
    private String productUid;
    private String clientName;
    private String productName;

    public ClientProduct() {
    }

    public ClientProduct(String clientUid, String productUid, String clientName, String productName) {
        this.clientUid = clientUid;
        this.productUid = productUid;
        this.clientName = clientName;
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientUid() {
        return clientUid;
    }

    public void setClientUid(String clientUid) {
        this.clientUid = clientUid;
    }

    public String getProductUid() {
        return productUid;
    }

    public void setProductUid(String productUid) {
        this.productUid = productUid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", clientUid='" + clientUid + '\'' +
                ", productUid='" + productUid + '\'' +
                ", clientName='" + clientName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
