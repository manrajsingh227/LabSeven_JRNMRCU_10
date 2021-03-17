package com.cg.eis.exception;

public class InvalidSalaryException extends Exception {
	private static final long serialVersionUID = 2874589441215269575L;
	
	public InvalidSalaryException(String s) {
		System.out.println(s);
	}
}
