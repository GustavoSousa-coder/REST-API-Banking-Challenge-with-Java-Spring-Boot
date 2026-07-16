package com.challenge.Bank.clients.controller.doc;

import com.challenge.Bank.clients.DTO.AuthenticationRequestDTO;
import com.challenge.Bank.clients.DTO.AuthenticationResponseDTO;
import com.challenge.Bank.exceptions.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Authentication", description = "Client authentication and JWT token generation")
public interface AuthenticationControllerDoc {

    @Operation(
            summary = "Authenticate a client and generate a JWT token",
            description = "Authenticates a client using their login (the same value as the client's registered email) " +
                    "and password. On success, returns a JWT token valid for 2 hours, along with the client's unique " +
                    "identifier. This token must be sent in the Authorization header (as a Bearer token) to access " +
                    "protected endpoints. Authentication will fail if the credentials are invalid, or if the client's " +
                    "account is not active (e.g. disabled, blocked, or suspicious status)."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authentication successful, JWT token generated",
                    content = @Content(schema = @Schema(implementation = AuthenticationResponseDTO.class))),
            @ApiResponse(responseCode = "422", description = "Invalid login or password, or account is not active " +
                    "(disabled, blocked or suspicious)",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<AuthenticationResponseDTO> login(
            @Parameter(description = "Login credentials. The 'login' field corresponds to the client's registered email address",
                    example = "{\n" +
                            "  \"login\": \"joao.silva@email.com\",\n" +
                            "  \"password\": \"Senha@123\"\n" +
                            "}"
            )
            AuthenticationRequestDTO dto
    );

}
