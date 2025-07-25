package com.itau.transacoes.handler;

import com.itau.transacoes.exception.DataFuturaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // retorna 422
    @ExceptionHandler(DataFuturaException.class)
    public ResponseEntity<Void> handleDataFuturaException(DataFuturaException ex) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // retorna 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Void> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().build();
    }

    // retornar 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().build();
    }
}
