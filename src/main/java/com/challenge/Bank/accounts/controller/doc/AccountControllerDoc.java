package com.challenge.Bank.accounts.controller.doc;

import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.exceptions.ExceptionResponse;
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

@Tag(name = "Accounts", description = "establishment of account management")
public interface AccountControllerDoc {

    @Operation(
            summary = "Find all accounts by client id",
            description = "Retrieves all bank accounts linked to a specific client, identified by the client's UUID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accounts found successfully",
                    content = @Content(schema = @Schema(implementation = AccountResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Client not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<List<AccountResponseDTO>> findAllByClientId(
            @Parameter(description = "Unique identifier of the client", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID ClientUuid
    );


    @Operation(
            summary = "Find account by id",
            description = "Retrieves the details of a specific bank account based on the provided account UUID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found successfully",
                    content = @Content(schema = @Schema(implementation = AccountResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<AccountResponseDTO> findById(
            @Parameter(description = "Unique identifier of the account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID uuid
    );


    @Operation(
            summary = "Create a new account for a client",
            description = "Creates a new bank account linked to the given client. The client must exist and be active. " +
                    "A client can have a maximum of 2 accounts."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully",
                    content = @Content(schema = @Schema(implementation = AccountResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "409", description = "Account limit exceeded for this client (maximum of 2 accounts)",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "422", description = "Client not found, client is not active, or invalid client id",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    AccountResponseDTO save(
            @Parameter(description = "Unique identifier of the client who will own the account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID clientUuid
    );


    @Operation(
            summary = "Deactivate an account",
            description = "Deactivates (closes) a specific bank account based on the provided account UUID. " +
                    "The account is not deleted from the database, only its status is changed to CLOSED."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deactivated successfully"),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "422", description = "Account not found",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<Void> delete(
            @Parameter(description = "Unique identifier of the account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID uuid
    );

}
