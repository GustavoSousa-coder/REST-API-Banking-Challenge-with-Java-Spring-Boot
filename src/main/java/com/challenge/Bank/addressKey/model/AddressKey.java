package com.challenge.Bank.addressKey.model;

import com.challenge.Bank.Enums.KeyType;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "AddressKey")
public class AddressKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "key_value", unique = true, nullable = false)
    private String keyValue;

    @Setter(AccessLevel.PUBLIC)
    @Enumerated(EnumType.STRING)
    private KeyType keyType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
}
