package com.challenge.Bank.transactions.repository;

import com.challenge.Bank.transactions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query("SELECT t FROM Transaction t WHERE t.dataHora > :data")
    List<Transaction> findRecentTransactions(@Param("data") OffsetDateTime data);

}
