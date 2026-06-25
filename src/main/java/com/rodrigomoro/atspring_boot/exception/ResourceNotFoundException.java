package com.rodrigomoro.atspring_boot.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
