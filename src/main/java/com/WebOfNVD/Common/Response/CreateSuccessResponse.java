package com.WebOfNVD.Common.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateSuccessResponse extends SuccessResponse {

	private static final long serialVersionUID = 1L;

	private String id;

}
