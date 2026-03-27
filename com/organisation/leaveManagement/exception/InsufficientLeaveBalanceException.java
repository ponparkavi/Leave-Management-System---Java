package com.organisation.leaveManagement.exception;

public class InsufficientLeaveBalanceException extends Exception{
	private static final long serialVersionUID = 1L;

	public InsufficientLeaveBalanceException(String msg) {
		super(msg);
	}
}
