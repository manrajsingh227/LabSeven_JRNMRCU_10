package com.cg.eis.exception;

public class InvalidIdException extends Exception{

	private static final long serialVersionUID = 8529736811501232959L;

	public InvalidIdException(String s) {
		System.out.println(s);
	}
}
