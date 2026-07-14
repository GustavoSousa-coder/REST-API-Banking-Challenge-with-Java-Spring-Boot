package com.challenge.Bank.card.model;

import com.challenge.Bank.Enums.CardStatus;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "card_number", unique = true, nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

    @Column(name = "expiration_date", nullable = false)
    private YearMonth expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder.Default
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();
}