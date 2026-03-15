package com.challenge.Bank.statistics.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class StatisticsResponseDTO {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public StatisticsResponseDTO() {
    }
    public StatisticsResponseDTO(Long count, Double sum, Double avg, Double min, Double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "StatisticsDTO{" +
                "count=" + count +
                ", sum=" + sum +
                ", avg=" + avg +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
