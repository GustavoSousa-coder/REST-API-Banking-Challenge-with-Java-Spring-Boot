package com.challenge.Bank.clients.controller.doc;

import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
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

@Tag(name = "Clients", description = "creation of customer management")
public interface ClientControllerDoc {


    @Operation(
            summary = "searches across all clients",
            description = "It searches for all customers without requiring any parameters and returns a list of all customers; however, only an ADMIN can perform this search."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully retrieved", content = @Content(schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Data not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    ResponseEntity<List<ClientResponseDTO>> findAll();



    @Operation(
            summary = "searches for a client by ID",
            description = "It performs a search for a specific client based on the provided ID and returns the client's details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully retrieved", content = @Content(schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "404", description = "Data not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    ResponseEntity<ClientResponseDTO> findById(
            @Parameter(description = "unique identifier of the client generated automatically after creation", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID uuid
    );



    @Operation(
            summary = "creates a new client",
            description = "It creates a new client based on the provided data and returns the details of the created client."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created", content = @Content(schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "409", description = "Data conflict"),
            @ApiResponse(responseCode = "403", description = "Unauthorized"),
            @ApiResponse(responseCode = "422", description = "Incomplete or invalid data")
    })
    ClientResponseDTO save(
            @Parameter(description = "Fields required for creating a new client",
                    example = "{\n" +
                            "  \"name\": \"João da Silva\",\n" +
                            "  \"cpf\": \"12345678909\",\n" +
                            "  \"dateOfBirth\": \"15/08/1998\",\n" +
                            "  \"email\": \"joao.silva@email.com\",\n" +
                            "  \"password\": \"Senha@123\"\n" +
                            "}"
            )
            ClientRequestDTO clientRequestDTO
    );



    @Operation(
            summary = "deactivates a client",
            description = "Deactivates a specific client based on the provided ID; however, only an ADMIN can perform this action."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client deactivated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    ResponseEntity<Void> deactivateUser(
            @Parameter(description = "unique identifier of the client generated automatically after creation", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID uuid
    );

}
