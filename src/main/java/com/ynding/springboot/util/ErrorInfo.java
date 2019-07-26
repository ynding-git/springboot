package com.ynding.springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ErrorInfo {

	@Getter
	private int code;
	@Getter
	private String message;
}
