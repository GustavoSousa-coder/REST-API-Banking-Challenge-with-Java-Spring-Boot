package com.challenge.Bank.statistics.controller;

import com.challenge.Bank.statistics.DTO.StatisticsResponseDTO;
import com.challenge.Bank.statistics.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1/estatistica")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatisticsResponseDTO> constructorStatistics(
            @RequestParam(value = "TimeSearch", required = false, defaultValue = "60") Integer TimeSearch) {
        return ResponseEntity.ok(statisticsService.calcularStatistics(TimeSearch));
    }

}
