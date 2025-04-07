package com.banco.demo.exception;


import org.springframework.context.annotation.Bean;

public class UserNotFindException extends RuntimeException {
    public UserNotFindException(String mensagem) {
        super(mensagem);
    }
    public UserNotFindException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}