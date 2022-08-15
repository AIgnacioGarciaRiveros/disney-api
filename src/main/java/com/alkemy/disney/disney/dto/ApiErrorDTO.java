package com.alkemy.disney.disney.dto;

import java.util.Date;
public class ApiErrorDTO {
    //private Date date;
    private String message;
    private String statusCode;

    public ApiErrorDTO(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
