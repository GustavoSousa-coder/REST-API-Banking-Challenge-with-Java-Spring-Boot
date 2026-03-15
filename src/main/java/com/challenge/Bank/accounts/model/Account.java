package com.challenge.Bank.accounts.model;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;
import com.challenge.Bank.clients.model.Client;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Builder.Default
    @Column(name = "account_number", nullable = false, length = 5)
    private String accountNumber = "5706";

    @Builder.Default
    @Column(name = "agency_number",  nullable = false, length = 5)
    private String agencyNumber = "0001";

    @Builder.Default
    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Setter(AccessLevel.PUBLIC)
    @Column(name = "type", unique = false, nullable = false,  length = 10)
    private AccountType type;

    @Builder.Default
    @Column(name = "overdraft_limit", nullable = false)
    private Double overdraftLimit = 1.000;

    @Builder.Default
    @Setter(AccessLevel.PUBLIC)
    @Column(name = "status", unique = false, nullable = false, length = 10)
    private AccountStatus status = AccountStatus.ACTIVE;

    @Builder.Default
    @Column(name = "created_at",  nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Setter(AccessLevel.PUBLIC)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public void debit(BigDecimal valor) {
        this.balance = balance.subtract(valor);
    }

    public void creditor(BigDecimal valor) {
        this.balance = balance.add(valor);
    }
}
