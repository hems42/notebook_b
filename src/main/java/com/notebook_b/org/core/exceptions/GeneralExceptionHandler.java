package com.notebook_b.org.core.exceptions;

import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  @NotNull HttpStatus status,
                                                                  @NotNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseExceptionModel.class)
    public ResponseEntity<?> baseExceptionModelExceptionHandler(BaseExceptionModel exception) {
        return convertCustomException(exception, exception.getBaseStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> baseExceptionHandler(Exception exception) {

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("baslık", "bu bir başlık denemesidir");
        headers.add("baslık", "bu bir başlık denemesidir");
        headers.add("baslık", "bu bir başlık denemesidir");
        headers.add("baslık", "bu bir başlık denemesidir");
        headers.add("baslık", "bu bir başlık denemesidir");
        headers.add("baslık", "bu bir başlık denemesidir");
        headers.add("baslık", "bu bir başlık denemesidir");
        ResponseEntity responseEntity = new ResponseEntity(exception, headers, HttpStatus.BAD_REQUEST);


        return responseEntity;
    }


    private ResponseEntity convertCustomException(BaseExceptionModel exceptionModel, HttpStatus httpStatus) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("errorFlag", "true");

        Map<String, String> body = new HashMap<>();
        body.put("errorCode", exceptionModel.getErrorCode());
        body.put("errorMessage", exceptionModel.getErrorMessage());
        body.put("errorDescription", exceptionModel.getErrorDescription());

        return new ResponseEntity<>(
                body, headers, httpStatus);
    }

}


