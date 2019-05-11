package org.sber.service.testservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Client {
    // сгенерированный id для отображения в браузере
    private Long id;
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
}
