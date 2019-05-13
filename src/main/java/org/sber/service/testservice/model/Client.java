package org.sber.service.testservice.model;

import lombok.NonNull;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@ToString(of = {"uid", "name", "balance"})
public class Client {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    //private UUID uid;
    private Integer uid;
    @NonNull
    private String name;
    @NonNull
    private String balance;

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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
