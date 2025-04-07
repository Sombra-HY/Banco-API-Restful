package com.banco.demo.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new  ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotFindException.class)
    public ResponseEntity<String> handleNotFoundException() {
        return new  ResponseEntity<>("Resource Id not found", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleunEcpectedException(Throwable unexpectedException) {
        var  msg = "Unexpect server error";
        logger.error(msg, unexpectedException);

        return new  ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
