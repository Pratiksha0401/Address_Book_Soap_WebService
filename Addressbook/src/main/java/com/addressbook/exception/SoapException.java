package com.addressbook.exception;

@SuppressWarnings("serial")
public class SoapException extends RuntimeException{
	
	public SoapException(String message) {
		super(message);
	}

}
