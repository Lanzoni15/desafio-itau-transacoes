package com.itau.transacoes.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class TransacaoDTO {

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "O valor deve ser zero ou positivo")
    private BigDecimal valor;

    @NotNull
    @Schema(type = "string", format = "date-time", example = "2025-07-25T14:15:22Z")
    private OffsetDateTime dataHora;

    // Getters e setters

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
