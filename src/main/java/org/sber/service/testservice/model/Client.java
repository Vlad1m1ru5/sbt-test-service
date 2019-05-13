package org.sber.service.testservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Client {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 16)
    private UUID uid;
    //private Integer uid;
    private String name;
    private String balance;

    /**
     *  public Integer getUid() {
     *         return uid;
     *     }
     *
     *     public void setUid(Integer uid) {
     *         this.uid = uid;
     *     }
     */

    public UUID getUid() {
        return uid;
    }
    public void setUid(UUID uid) {
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
