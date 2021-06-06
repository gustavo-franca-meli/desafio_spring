package com.mercadolibre.desafiospring.aplication.ExceptionHandlers;

import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyFollowingException;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyUnfollowingException;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
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

    @ExceptionHandler(UserIsAlreadyFollowingException.class)
    public ResponseEntity<Void> userIsAlReadyFollowing(UserIsAlreadyFollowingException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @ExceptionHandler(UserIsAlreadyUnfollowingException.class)
    public ResponseEntity<Void> userIsAlReadyUnfollowing(UserIsAlreadyUnfollowingException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Void> userNotfound(UserNotFound e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
