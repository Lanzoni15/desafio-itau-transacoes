package com.itau.transacoes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.transacoes.dto.EstatisticaDTO;
import com.itau.transacoes.dto.TransacaoDTO;
import com.itau.transacoes.service.TransacaoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    // POST
    @PostMapping
    public ResponseEntity<String> adicionarTransacao(@Valid @RequestBody TransacaoDTO transacao) {
        boolean sucesso = transacaoService.adicionarTransacao(transacao);

        if (sucesso) {
            return ResponseEntity.status(201).body("Transação adicionada com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Transação inválida (data futura ou valor negativo).");
        }
    }

    // GET
    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDTO> buscarEstatistica() {
        EstatisticaDTO estatistica = transacaoService.calcularEstatisticas();
        return ResponseEntity.ok(estatistica);
    }

    // DELETE

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes() {
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }

}
