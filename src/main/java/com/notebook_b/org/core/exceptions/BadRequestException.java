package com.notebook_b.org.core.exceptions;

import com.notebook_b.org.core.exceptions.abstracts.BaseException;

public class BadRequestException extends BaseException {
    public BadRequestException(String message, Integer statusCode) {
        super.message=message;
        super.statusCode=statusCode;
    }
}
