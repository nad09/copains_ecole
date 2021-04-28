package com.example.copains_ecole.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "champs vides")
public class MissingInformationException extends RuntimeException {
    public MissingInformationException(){
        super();
    }
}

