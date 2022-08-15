package com.alkemy.disney.disney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String field;
    private String valueField;
    //TODO:Verificar si falta


    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resource, String field, String valueField) {
        super(String.format("%s not found with %s : '%s'",resource,field,valueField));
        this.resource = resource;
        this.field = field;
        this.valueField = valueField;
    }


}
