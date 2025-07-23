package com.itau.transacoes.transacaoService;

import com.itau.transacoes.TransacaoDTO;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
        if (transacao.getValor().compareTo(java.math.BigDecimal.ZERO) < 0) {
            return false;
        }

        transacoes.add(transacao);
        transacoes.clear();

    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public List<TransacaoDTO> getTransacoes() {
        return transacoes;
    }
}
