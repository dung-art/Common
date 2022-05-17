package com.WebOfNVD.Common.Response;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuccessResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private int status = 1;

}
