package com.challenge.Bank.addressKey.mapper;

import com.challenge.Bank.addressKey.DTO.AddressKeyRequestDTO;
import com.challenge.Bank.addressKey.DTO.AddressKeyResponseDTO;
import com.challenge.Bank.addressKey.model.AddressKey;
import org.springframework.stereotype.Component;

@Component
public class AddressKeyMapper {

    public AddressKey toEntity(AddressKeyRequestDTO dto) {
        return AddressKey.builder()
                .keyType(dto.keyType())
                .keyValue(dto.keyValue())
                .uuid(dto.accountId())
                .build();
    }

    public AddressKeyResponseDTO toDTO(AddressKey entity) {
        return new AddressKeyResponseDTO(
                entity.getKeyType(),
                entity.getKeyValue()
        );
    }

}
