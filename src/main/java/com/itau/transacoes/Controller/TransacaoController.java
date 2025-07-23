package com.itau.transacoes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.transacoes.dto.TransacaoDTO;
import com.itau.transacoes.service.TransacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<String> adicionarTransacao(@Valid @RequestBody TransacaoDTO transacao) {
        boolean sucesso = transacaoService.adicionarTransacao(transacao);

        if (sucesso) {
            return ResponseEntity.status(201).body("Transação adicionada com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Transação inválida (data futura ou valor negativo).");
        }
    }
}
