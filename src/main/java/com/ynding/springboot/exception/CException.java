package com.ynding.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CException extends Exception implements Serializable {

    private ExceptionEnum exceptionEnum;

    private String errorDetail;

    public CException(ExceptionEnum exceptionEnum){
        this.exceptionEnum = exceptionEnum;
    }
}
