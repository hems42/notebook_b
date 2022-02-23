package com.notebook_b.org.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class AlReadyExistException extends RuntimeException{
    public AlReadyExistException(String message) {
        super(message);
    }
}
