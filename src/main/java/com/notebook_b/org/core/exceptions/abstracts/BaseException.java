package com.notebook_b.org.core.exceptions.abstracts;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public abstract class BaseException extends RuntimeException {

    public String message;
    public Integer statusCode;
}
