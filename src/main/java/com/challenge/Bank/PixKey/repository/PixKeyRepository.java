package com.challenge.Bank.PixKey.repository;

import com.challenge.Bank.PixKey.model.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PixKeyRepository extends JpaRepository<PixKey, UUID> {

    PixKey findByKeyValue(String value);

}
