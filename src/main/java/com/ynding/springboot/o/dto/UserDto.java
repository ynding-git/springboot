package com.ynding.springboot.o.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

}
