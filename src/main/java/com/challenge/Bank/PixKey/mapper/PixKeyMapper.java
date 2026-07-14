package com.challenge.Bank.PixKey.mapper;

import com.challenge.Bank.PixKey.DTO.PixTransferRequestDTO;
import com.challenge.Bank.PixKey.DTO.PixTransferResponseDTO;
import com.challenge.Bank.PixKey.model.PixKey;
import org.springframework.stereotype.Component;

@Component
public class PixKeyMapper {

    public PixKey toEntity(PixTransferRequestDTO dto) {
        return PixKey.builder()
                .keyType(dto.keyType())
                .keyValue(dto.keyValue())
                .uuid(dto.accountId())
                .build();
    }

    public PixTransferResponseDTO toDTO(PixKey entity) {
        return new PixTransferResponseDTO(
                entity.getKeyType(),
                entity.getKeyValue()
        );
    }

}
