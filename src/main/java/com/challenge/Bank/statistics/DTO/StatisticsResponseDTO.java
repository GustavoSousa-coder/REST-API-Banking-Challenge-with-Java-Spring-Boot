package com.challenge.Bank.statistics.DTO;

import java.util.Objects;

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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsResponseDTO that = (StatisticsResponseDTO) o;
        return Objects.equals(getCount(), that.getCount()) && Objects.equals(getSum(), that.getSum()) && Objects.equals(getAvg(), that.getAvg()) && Objects.equals(getMin(), that.getMin()) && Objects.equals(getMax(), that.getMax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount(), getSum(), getAvg(), getMin(), getMax());
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
