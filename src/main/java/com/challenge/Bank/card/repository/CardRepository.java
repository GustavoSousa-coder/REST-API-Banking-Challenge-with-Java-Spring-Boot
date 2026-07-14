package com.challenge.Bank.card.repository;

import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByCardNumber(String cardNumber);

    boolean existsByAccount(Account account);

    Optional<Card> findByCardNumber(String cardNumber);

}