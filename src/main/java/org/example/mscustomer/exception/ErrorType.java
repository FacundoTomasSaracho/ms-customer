package org.example.mscustomer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorType {

    MANDATORY_REQUEST("Mandatory value is missing. Check request.", 1001);

    private final String message;
    private final Integer code;


}
