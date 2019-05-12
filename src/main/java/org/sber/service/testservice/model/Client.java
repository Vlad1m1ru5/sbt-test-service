package org.sber.service.testservice.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"uid", "name", "balance"})
public class Client {
    @Id
    @NonNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "uid", columnDefinition = "CHAR(32)", updatable = false, unique = true)
    private UUID uid;
    @NonNull
    private String name;
    @NonNull
    private String balance;
}
