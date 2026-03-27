package com.organisation.leaveManagement.exception;

public class InvalidLeaveRequestException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidLeaveRequestException(String msg) {
		super(msg);
	}
}
