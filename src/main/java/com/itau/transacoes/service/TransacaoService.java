package com.itau.transacoes.service;

import org.springframework.stereotype.Service;

import com.itau.transacoes.dto.TransacaoDTO;

import java.math.BigDecimal;
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
}
