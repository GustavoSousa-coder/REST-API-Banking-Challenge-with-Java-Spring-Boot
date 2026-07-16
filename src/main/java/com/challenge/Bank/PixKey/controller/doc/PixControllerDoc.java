package com.challenge.Bank.PixKey.controller.doc;

import com.challenge.Bank.PixKey.DTO.PixTransferRequestDTO;
import com.challenge.Bank.PixKey.DTO.PixTransferResponseDTO;
import com.challenge.Bank.exceptions.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


import java.util.UUID;

@Tag(name = "PixKey", description = "Registration and management of Pix keys")
public interface PixControllerDoc {

    @Operation(
            summary = "Register a Pix key for an account",
            description = "Registers a new Pix key (e.g. CPF, email, phone or random key) and links it to an existing " +
                    "bank account. This key can later be used to look up the account and perform Pix transactions. " +
                    "The account must exist and be active."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pix key registered successfully",
                    content = @Content(schema = @Schema(implementation = PixTransferResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "422", description = "Account is not active",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<Object> registerAddressKey(

            @Parameter(description = "Pix key data to be registered, including key type and value",
                    example = "{\n" +
                            "  \"keyType\": \"EMAIL\",\n" +
                            "  \"keyValue\": \"joao.silva@email.com\",\n" +
                            "  \"accountId\": \"123e4567-e89b-12d3-a456-426614174000\"\n" +
                            "}"
            )
            PixTransferRequestDTO pixTransferRequestDTO,

            @Parameter(description = "Unique identifier of the account that will own the Pix key", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID accountId
    );

}
