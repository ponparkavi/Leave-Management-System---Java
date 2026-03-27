package com.organisation.leaveManagement.util;
import com.organisation.leaveManagement.exception.InvalidLeaveRequestException;
import com.organisation.leaveManagement.model.LeaveRequest.Leave;

public class ValidationUtil {
	
	public static void validateString(String value, String fieldname)
		
		throws InvalidLeaveRequestException {
			
			if(value == null || value.trim().isEmpty()) {
				throw new InvalidLeaveRequestException(fieldname + " Cannot be Empty ");
				
			}
			
		}
	
	public static void validateLeaveDays(int days) throws InvalidLeaveRequestException {
		
		if(days<=0) {
			throw new InvalidLeaveRequestException(" Leave Days must be greater than 0");
		}
	}
		
	public static void validateLeaveType(Leave type) throws InvalidLeaveRequestException{
		
		if(type == null) {
			throw new InvalidLeaveRequestException("Invalid Leave type ");
			
		}
	}
		
	
}
