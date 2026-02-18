package com.challenge.Bank.addressKey.mapper;

import com.challenge.Bank.addressKey.DTO.AddressKeyRequestDTO;
import com.challenge.Bank.addressKey.DTO.AddressKeyResponseDTO;
import com.challenge.Bank.addressKey.model.AddressKey;
import org.springframework.stereotype.Component;

@Component
public class AddressKeyMapper {

    public AddressKey toEntity(AddressKeyRequestDTO dto) {
        AddressKey addressKey = new AddressKey();
        addressKey.setKeyType(dto.getKeyType());
        addressKey.setKeyValue(dto.getKeyValue());
        return addressKey;
    }

    public AddressKeyResponseDTO toDTO(AddressKey entity) {
        AddressKeyResponseDTO dto = new AddressKeyResponseDTO();
        dto.setKeyType(entity.getKeyType());
        dto.setKeyValue(entity.getKeyValue());
        return dto;
    }

}
