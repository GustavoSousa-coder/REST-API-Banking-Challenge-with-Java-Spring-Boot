package com.challenge.Bank.clients.model;

import com.challenge.Bank.Enums.ClientStatus;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "date_of_birth", nullable = false, length = 10)
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Setter(AccessLevel.NONE)
    @Column(name = "password", length = 100)
    private String password;

    @Setter(AccessLevel.PUBLIC)
    @Builder.Default
    @Column(name = "client_status", nullable = false, length = 10)
    private ClientStatus clientStatus = ClientStatus.Active;

    @Builder.Default
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();
}