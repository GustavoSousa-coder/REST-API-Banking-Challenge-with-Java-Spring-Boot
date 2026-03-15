package com.challenge.Bank.transactions.model;

import com.challenge.Bank.Enums.TransactionStatus;
import com.challenge.Bank.Enums.TransactionType;
import com.challenge.Bank.accounts.model.Account;
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
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Builder.Default
    @Column(name = "amount",  nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;

    @Setter(AccessLevel.PUBLIC)
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Setter(AccessLevel.PUBLIC)
    @Column(name = "status")
    private TransactionStatus status;

    @Builder.Default
    @Column(name = "data_hora",  nullable = false)
    private OffsetDateTime dataHora = OffsetDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

}
