package com.challenge.Bank.card.mapper;

import com.challenge.Bank.card.DTO.CardResponseDTO;
import com.challenge.Bank.card.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardResponseDTO toDTO(Card entity) {
        return new CardResponseDTO(
                entity.getUuid(),
                maskCardNumber(entity.getCardNumber()),
                entity.getHolderName(),
                entity.getExpirationDate(),
                entity.getStatus(),
                entity.getCreatedAt()
        );
    }

    private String maskCardNumber(String cardNumber) {

        return "**** **** **** " + cardNumber.substring(12);

    }

}