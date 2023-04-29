package com.avisys.cim.Dto;


//adding a class to show responce message.
public class ResponseDto {
	
	private String message;

	public ResponseDto(String message) {
		
		
		this.message = message;
	}

	public ResponseDto() {
	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
