package com.challenge.Bank.controller;

import com.challenge.Bank.DTO.response.StatisticsResponseDTO;
import com.challenge.Bank.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estatistica/v1")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Constructor Statistics",
            description = "This endpoint is capable of retrieving and generating transaction statistics with a custom time range",
            tags = {"Statistics"},
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200", content = @Content),
            }
    )
    public ResponseEntity<StatisticsResponseDTO> constructorStatistics(
            @RequestParam(value = "TimeSearch", required = false, defaultValue = "60") Integer TimeSearch) {
        return ResponseEntity.ok(statisticsService.calcularStatistics(TimeSearch));
    }

}
