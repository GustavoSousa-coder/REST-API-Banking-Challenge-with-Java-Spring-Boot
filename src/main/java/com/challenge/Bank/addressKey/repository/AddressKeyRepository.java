package com.challenge.Bank.addressKey.repository;

import com.challenge.Bank.addressKey.model.AddressKey;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressKeyRepository extends JpaRepository<AddressKey, UUID> {

    AddressKey findByKeyValue(String value);

}
