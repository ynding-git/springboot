package com.ynding.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CmiException extends Exception {

    private String message;
}
