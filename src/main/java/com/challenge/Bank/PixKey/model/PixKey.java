package com.challenge.Bank.PixKey.model;

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
@Table(name = "tb_pix_keys")
public class PixKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "key_value", unique = true, nullable = false)
    private String keyValue;

    @Setter(AccessLevel.PUBLIC)
    @Enumerated(EnumType.STRING)
    @Column(name = "key_type", nullable = false)
    private KeyType keyType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
}
