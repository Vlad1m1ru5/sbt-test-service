package org.sber.service.testservice.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid2")
    //@Column(name = "uid", columnDefinition = "CHAR(32)", updatable = false, unique = true)
    //private UUID uid;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    private String name;
    private String demand;

    public Product() {
    }

    public Product(String name, String demand) {
        this.name = name;
        this.demand = demand;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        return "{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", demand='" + demand + '\'' +
                '}';
    }
}
