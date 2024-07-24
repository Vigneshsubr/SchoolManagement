package com.school.schoolmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
	
	private String message;
	private Object data;
	private Integer statusCode;

}
