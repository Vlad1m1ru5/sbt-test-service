package org.sber.service.testservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class ClientProduct {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 16)
    private UUID uid;
    @Column(length = 16)
    private UUID clientUid;
    private String clientName;
    @Column(length = 16)
    private UUID productUid;
    private String productName;

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public UUID getClientUid() {
        return clientUid;
    }

    public void setClientUid(UUID clientUid) {
        this.clientUid = clientUid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public UUID getProductUid() {
        return productUid;
    }

    public void setProductUid(UUID productUid) {
        this.productUid = productUid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "ClientProduct{" +
                "uid=" + uid +
                ", clientUid=" + clientUid +
                ", clientName='" + clientName + '\'' +
                ", productUid=" + productUid +
                ", productName=" + productName +
                '}';
    }
}
