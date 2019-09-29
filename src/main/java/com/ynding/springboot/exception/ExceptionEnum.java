package com.ynding.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.beans.ExceptionListener;

@AllArgsConstructor
public enum ExceptionEnum {

    USER_AlREAD_EXIST_EXCEPTION("401","用户不存在");

    @Getter
    private String eCode;
    @Getter
    private String eMsg;

}
