package com.itau.transacoes.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class TransacaoDTO {

    // Valor
    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    public TransacaoDTO() {
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    // DataHora
    @NotNull
    private OffsetDateTime dataHora;

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
