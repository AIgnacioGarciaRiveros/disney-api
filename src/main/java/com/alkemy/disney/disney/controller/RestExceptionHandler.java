package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.ApiErrorDTO;
import com.alkemy.disney.disney.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<ApiErrorDTO>handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ApiErrorDTO errorDetails = new ApiErrorDTO(exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ApiErrorDTO>handleGlobalException(Exception exception, WebRequest webRequest){
        ApiErrorDTO errorDetails = new ApiErrorDTO(exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
