package com.itau.transacoes.controller;

import com.itau.transacoes.dto.EstatisticaDTO;
import com.itau.transacoes.dto.TransacaoDTO;
import com.itau.transacoes.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @Operation(summary = "Adiciona uma nova transação")
    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@Valid @RequestBody TransacaoDTO transacao) {
        boolean sucesso = transacaoService.adicionarTransacao(transacao);

        if (sucesso) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @Operation(summary = "Retorna estatísticas das transações dos últimos 60 segundos")
    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDTO> buscarEstatistica() {
        EstatisticaDTO estatistica = transacaoService.calcularEstatisticas();
        return ResponseEntity.ok(estatistica);
    }

    @Operation(summary = "Remove todas as transações")
    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes() {
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }
}
