package com.challenge.Bank.transactions.controller.doc;

import com.challenge.Bank.exceptions.ExceptionResponse;
import com.challenge.Bank.transactions.DTO.TimeFilterDTO;
import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Transactions", description = "Endpoints for creating and retrieving bank transactions")
public interface TransactionControllerDoc {

    @Operation(
            summary = "Transfer money between accounts",
            description = "Performs a money transfer from one account to another. The transfer can be made either " +
                    "via a Pix key (method = PIX) or via card authorization (method = CARD). " +
                    "For PIX transfers, the sender is identified by the account id in the path, and the receiver " +
                    "is identified by the Pix key. For CARD transfers, the sender is identified/authorized by the " +
                    "card data, and the receiver is identified by the Pix key. The sender and receiver accounts " +
                    "must be different and both must be active."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction completed successfully",
                    content = @Content(schema = @Schema(implementation = TransactionResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid amount (null or not positive), or invalid transaction method",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Sender account, card or Pix key not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "422", description = "Card is not active/expired/invalid CVV, sender and receiver are the same account, " +
                    "or one of the accounts is not active",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<TransactionResponseDTO> transfer(
            @Parameter(description = "Unique identifier of the sender account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID accountId,

            @Parameter(description = "Transaction data, including amount, method (PIX or CARD), destination Pix key, " +
                    "and card data (required only when method = CARD)",
                    example = "{\n" +
                            "  \"amount\": 150.00,\n" +
                            "  \"key\": \"joao.silva@email.com\",\n" +
                            "  \"method\": \"PIX\",\n" +
                            "  \"cardDto\": null\n" +
                            "}"
            )
            TransactionRequestDTO transactionRequestDTO
    );


    @Operation(
            summary = "Get transactions by time window",
            description = "Retrieves all recent transactions for a given account, filtered by a time window in seconds " +
                    "counted backwards from the current moment."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transactions retrieved successfully",
                    content = @Content(schema = @Schema(implementation = TransactionResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<List<TransactionResponseDTO>> getTransactions(
            @Parameter(description = "Unique identifier of the account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID accountId,

            @Parameter(description = "Time window, in seconds, counted backwards from now, used to filter transactions", example = "3600")
            Integer TimeSearch
    );


    @Operation(
            summary = "Get transactions with a customized time filter",
            description = "Retrieves transactions for a given account using a flexible time filter. The filter type " +
                    "can be SECONDS, DAYS, MONTHS, YEARS (relative to now), or FROM_DATE (an absolute start date in " +
                    "dd/MM/yyyy format, combined with an optional time zone)."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transactions retrieved successfully",
                    content = @Content(schema = @Schema(implementation = TransactionResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "422", description = "Invalid date format (dateIso must be dd/MM/yyyy), or invalid filter type",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<List<TransactionResponseDTO>> getTransactionByPersonaliseTime(
            @Parameter(description = "Unique identifier of the account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID accountId,

            @Parameter(description = "Custom time filter data",
                    example = "{\n" +
                            "  \"type\": \"FROM_DATE\",\n" +
                            "  \"amount\": 0,\n" +
                            "  \"zone\": \"America/Sao_Paulo\",\n" +
                            "  \"dateIso\": \"01/07/2026\"\n" +
                            "}"
            )
            TimeFilterDTO filter
    );

}
