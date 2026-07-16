package com.challenge.Bank.statistics.controller.doc;

import com.challenge.Bank.exceptions.ExceptionResponse;
import com.challenge.Bank.statistics.DTO.StatisticsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Statistics", description = "Endpoints for statistics-related operations")
public interface StatisticsControllerDoc {

    @Operation(
            summary = "Get transaction statistics for an account",
            description = "Calculates and returns aggregated statistics (count, sum, average, minimum and maximum) " +
                    "of the transactions made by a given account within a customizable time period, in minutes. " +
                    "If no time period is provided, the last 60 minutes are considered by default."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Statistics calculated successfully",
                    content = @Content(schema = @Schema(implementation = StatisticsResponseDTO.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404", description = "No transactions found for the given account within the specified period, or account does not exist",
                    content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<StatisticsResponseDTO> constructorStatistics(
            @Parameter(description = "Unique identifier of the account", example = "123e4567-e89b-12d3-a456-426614174000")
            UUID accountId,

            @Parameter(description = "Time period, in minutes, to consider when calculating statistics. Defaults to 60 minutes if not provided.", example = "60")
            Integer TimeSearch
    );

}
