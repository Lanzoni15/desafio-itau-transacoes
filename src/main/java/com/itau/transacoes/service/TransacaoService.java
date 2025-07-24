package com.itau.transacoes.service;

import org.springframework.stereotype.Service;

import com.itau.transacoes.dto.EstatisticaDTO;
import com.itau.transacoes.dto.TransacaoDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<TransacaoDTO> transacoes = new ArrayList();

    public boolean adicionarTransacao(TransacaoDTO transacao) {
        OffsetDateTime agora = OffsetDateTime.now();

        // data futura
        if (transacao.getDataHora().isAfter(agora)) {
            return false;
        }

        // valor negativo
        if (transacao.getValor().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        transacoes.add(transacao);
        return true;

    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public List<TransacaoDTO> getTransacoes() {
        return transacoes;
    }

    public EstatisticaDTO calcularEstatisticas() {
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limite = agora.minusSeconds(60);

        List<TransacaoDTO> ultimasTransacoes = transacoes.stream()
                .filter(t -> !t.getDataHora().isBefore(limite))
                .toList();

        if (ultimasTransacoes.isEmpty()) {
            return new EstatisticaDTO(0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }

        // soma
        BigDecimal sum = ultimasTransacoes.stream()
                .map(TransacaoDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // média
        BigDecimal avg = sum.divide(BigDecimal.valueOf(ultimasTransacoes.size()), 2, RoundingMode.HALF_UP);

        // menor valor
        BigDecimal min = ultimasTransacoes.stream()
                .map(TransacaoDTO::getValor)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        // maior valor
        BigDecimal max = ultimasTransacoes.stream()
                .map(TransacaoDTO::getValor)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        return new EstatisticaDTO(
                ultimasTransacoes.size(),
                sum,
                avg,
                min,
                max);
    }

}
