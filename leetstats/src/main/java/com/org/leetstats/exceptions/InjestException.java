package com.org.leetstats.exceptions;

import com.org.leetstats.enums.InjestExceptionEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InjestException extends RuntimeException{

    private final InjestExceptionEnum type;

    private final String LogMessage;

    public InjestException(String logMessage){
        throw new InjestException(InjestExceptionEnum.INTERNAL_SERVER_ERROR, logMessage);
    }

}
