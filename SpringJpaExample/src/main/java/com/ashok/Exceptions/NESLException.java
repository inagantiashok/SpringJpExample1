package com.ashok.Exceptions;

public class NESLException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NESLException(String msg) {
		super(msg);
	}
	public NESLException(String msg,Throwable t) {
		super(msg);
	}

}
