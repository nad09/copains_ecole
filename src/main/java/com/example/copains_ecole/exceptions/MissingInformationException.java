package com.example.copains_ecole.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "champs vides ou null")
public class MissingInformationException extends RuntimeException {
public MissingInformationException(){
    super();
}
}
