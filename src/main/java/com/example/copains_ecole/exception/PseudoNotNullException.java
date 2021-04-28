package com.example.copains_ecole.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Ce pseudo n'est pas unique")
public class PseudoNotNullException extends RuntimeException {
    public PseudoNotNullException(){
        super();
    }
}