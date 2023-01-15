package com.org.leetstats.enums;

import com.org.leetstats.exceptions.InjestException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum InjestExceptionEnum {

    INTERNAL_SERVER_ERROR("some error occured", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("json is invalid", HttpStatus.BAD_REQUEST);

    private final  String message;
    private final HttpStatus status;

}
