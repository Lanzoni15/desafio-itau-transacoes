package com.itau.transacoes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.transacoes.dto.EstatisticaDTO;
import com.itau.transacoes.dto.TransacaoDTO;
import com.itau.transacoes.exception.DataFuturaException;
import com.itau.transacoes.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransacaoController.class)
public class TransacaoControllerTest {

    @MockBean
    private TransacaoService transacaoService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void deveAdicionarTransacaoValida() throws Exception {
        TransacaoDTO transacao = new TransacaoDTO();
        transacao.setValor(new BigDecimal("100.00"));
        transacao.setDataHora(OffsetDateTime.now());

        when(transacaoService.adicionarTransacao(any())).thenReturn(true);

        mockMvc.perform(post("/transacao")
                .contentType(APPLICATION_JSON)
                .content(mapper.writeValueAsString(transacao)))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveRejeitarTransacaoComValorNegativo() throws Exception {
        TransacaoDTO transacao = new TransacaoDTO();
        transacao.setValor(new BigDecimal("-100.00"));
        transacao.setDataHora(OffsetDateTime.now());

        when(transacaoService.adicionarTransacao(any())).thenReturn(false);

        mockMvc.perform(post("/transacao")
                .contentType(APPLICATION_JSON)
                .content(mapper.writeValueAsString(transacao)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveRejeitarTransacaoComDataFutura() throws Exception {
        TransacaoDTO transacao = new TransacaoDTO();
        transacao.setValor(new BigDecimal("100.00"));
        transacao.setDataHora(OffsetDateTime.now().plusMinutes(5));

        doThrow(new DataFuturaException("A dataHora da transação não pode ser futura"))
            .when(transacaoService).adicionarTransacao(any());

        mockMvc.perform(post("/transacao")
                .contentType(APPLICATION_JSON)
                .content(mapper.writeValueAsString(transacao)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("A dataHora da transação não pode ser futura"));
    }

    @Test
    public void deveRetornarEstatisticas() throws Exception {
        EstatisticaDTO estatistica = new EstatisticaDTO(
                2,
                new BigDecimal("200.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"),
                new BigDecimal("100.00"));

        when(transacaoService.calcularEstatisticas()).thenReturn(estatistica);

        mockMvc.perform(get("/transacao/estatistica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2))
                .andExpect(jsonPath("$.sum").value(200.00))
                .andExpect(jsonPath("$.avg").value(100.00))
                .andExpect(jsonPath("$.min").value(100.00))
                .andExpect(jsonPath("$.max").value(100.00));
    }

    @Test
    public void deveLimparTransacoes() throws Exception {
        mockMvc.perform(delete("/transacao"))
                .andExpect(status().isOk());
    }
}
