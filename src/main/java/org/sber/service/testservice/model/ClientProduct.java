package org.sber.service.testservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientProduct {
    @Id
    @NonNull
    private Long id;
    @NonNull
    private String clientUid;
    @NonNull
    private String productUid;
    @NonNull
    private String clientName;
    @NonNull
    private String productName;
}
