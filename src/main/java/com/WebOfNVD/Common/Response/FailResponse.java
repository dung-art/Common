package com.WebOfNVD.Common.Response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FailResponse extends SuccessResponse implements Serializable {
	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FailResponse(String message) {
		super.setStatus(0);
		this.message = message;
	}
}
