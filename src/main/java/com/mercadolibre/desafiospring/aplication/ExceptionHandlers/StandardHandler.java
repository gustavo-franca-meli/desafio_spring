package com.mercadolibre.desafiospring.aplication.ExceptionHandlers;

import com.sun.jdi.connect.VMStartException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class StandardHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> badRequest(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
