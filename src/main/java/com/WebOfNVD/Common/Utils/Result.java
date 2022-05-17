package com.WebOfNVD.Common.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Result<T> {
	private T valueT;
	private String message;
}
