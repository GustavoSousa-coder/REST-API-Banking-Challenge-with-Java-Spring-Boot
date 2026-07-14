package com.challenge.Bank.accounts.model;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.clients.model.Client;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_accounts")
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
    @Column(name = "balance", nullable = false, precision = 19, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Builder.Default
    @Column(name = "overdraft_limit", nullable = false, precision = 19, scale = 2)
    private BigDecimal overdraftLimit =  BigDecimal.valueOf(1000);

    @Enumerated(EnumType.STRING)
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

    @Builder.Default
    @Column(name = "withdrawal_count", nullable = false)
    private Integer withdrawalCount = 0;

    @Builder.Default
    @Column(name = "last_withdrawal_reset", nullable = false)
    private LocalDate lastWithdrawalReset = LocalDate.now();

    @Column(name = "daily_transfer_limit", nullable = false, precision = 19, scale = 2)
    @Builder.Default
    private BigDecimal dailyTransferLimit = BigDecimal.valueOf(5000);

    @Column(name = "daily_transfer_used", nullable = false, precision = 19, scale = 2)
    @Builder.Default
    private BigDecimal dailyTransferUsed = BigDecimal.ZERO;

    @Builder.Default
    @Column(name = "last_transfer_reset", nullable = false)
    private LocalDate lastTransferReset = LocalDate.now();

    public void debit(BigDecimal valor) {
        this.balance = balance.subtract(valor);
    }

    public void creditor(BigDecimal valor) {
        this.balance = balance.add(valor);
    }

    public void consumeDailyTransferLimit(BigDecimal amount) {

        if (!lastTransferReset.equals(LocalDate.now())) {
            dailyTransferUsed = BigDecimal.ZERO;
            lastTransferReset = LocalDate.now();
        }

        BigDecimal total = dailyTransferUsed.add(amount);

        if (total.compareTo(dailyTransferLimit) > 0) {
            throw new UnprocessableEntity("Daily transfer limit exceeded.");
        }

        dailyTransferUsed = total;
    }


}
