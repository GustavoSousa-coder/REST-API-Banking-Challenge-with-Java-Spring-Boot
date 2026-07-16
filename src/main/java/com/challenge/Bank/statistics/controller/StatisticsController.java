package com.challenge.Bank.statistics.controller;

import com.challenge.Bank.statistics.DTO.StatisticsResponseDTO;
import com.challenge.Bank.statistics.controller.doc.StatisticsControllerDoc;
import com.challenge.Bank.statistics.service.StatisticsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/estatistica")
public class StatisticsController implements StatisticsControllerDoc {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    @GetMapping(value = "/{accountId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatisticsResponseDTO> constructorStatistics(
            @PathVariable UUID accountId,
            @RequestParam(value = "TimeSearch", required = false, defaultValue = "60") Integer TimeSearch) {
        return ResponseEntity.of(statisticsService.calcularStatistics(accountId, TimeSearch));
    }

}
