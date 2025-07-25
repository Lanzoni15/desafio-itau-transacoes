package com.itau.transacoes.handler;

import jakarta.validation.ConstraintViolationException;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itau.transacoes.exception.DataFuturaException;

@ControllerAdvice
public class ValidacaoHandler {

    // 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> tratarValidacao(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().build();
    }

    // 400
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Void> tratarConstraint(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().build();
    }

    // 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> tratarErroGeral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(DataFuturaException.class)
    public ResponseEntity<Object> handleDataFuturaException(DataFuturaException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", ex.getMessage()));
    }
}
