package org.example.mscustomer.presentation.exception;

import org.example.mscustomer.exception.ErrorType;
import org.example.mscustomer.presentation.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDto> handleMethodArgumentNotValidException() {
        return new ResponseEntity<>(formErrorDto(), HttpStatus.BAD_REQUEST);
    }

    ErrorDto formErrorDto() {
        return new ErrorDto(ErrorType.MANDATORY_REQUEST.getMessage(), ErrorType.MANDATORY_REQUEST.getCode());
    }
}
