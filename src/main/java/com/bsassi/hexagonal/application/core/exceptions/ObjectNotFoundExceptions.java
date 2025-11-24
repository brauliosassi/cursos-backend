package com.bsassi.hexagonal.application.core.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException{

    public ObjectNotFoundExceptions(final String id){
        super("Object with id " + id + "not found!");
    }
}
