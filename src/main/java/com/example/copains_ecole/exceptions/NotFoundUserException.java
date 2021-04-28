package com.example.copains_ecole.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Le pseudo et le password indiqués ne correspondent à aucun utilisateur")
public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(){
        super();
    }
}
