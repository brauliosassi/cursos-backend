package com.bsassi.hexagonal.adapters.in.controller.handler;

import com.bsassi.hexagonal.application.core.exceptions.ObjectNotFoundExceptions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExceptions.class)
    public ResponseEntity<StandardError> objectNotFoundExceptionHandler(
            ObjectNotFoundExceptions e, HttpServletRequest request
    ){
        StandardError standardError = new StandardError(
                System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI()
        );

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

}
