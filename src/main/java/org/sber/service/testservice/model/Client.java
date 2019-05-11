package org.sber.service.testservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    // сгенерированный id для отображения в браузере
    @NonNull
    private Long id;
    @NonNull
    private String uid;
    @NonNull
    private String name;
    @NonNull
    private String product;


}
