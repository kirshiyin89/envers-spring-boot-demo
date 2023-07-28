package com.envers.demo.exception;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(Long id) {
        super("Could not find pet with id " + id);
    }
}
