package com.cognizant.exception;

public class InvalidAccountBalance extends RuntimeException {

	public InvalidAccountBalance(String s) {
		super(s);
	}

	public String negativeAccountBalance() {
		return "Insufficient Balance";
	}

}
