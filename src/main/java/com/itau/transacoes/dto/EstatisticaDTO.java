package com.itau.transacoes.dto;

import java.math.BigDecimal;

public class EstatisticaDTO {

    private final long count;
    private final BigDecimal sum;
    private final BigDecimal avg;
    private final BigDecimal min;
    private final BigDecimal max;

    public EstatisticaDTO(long count, BigDecimal sum, BigDecimal avg, BigDecimal min, BigDecimal max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public long getCount() {
        return count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }
}
