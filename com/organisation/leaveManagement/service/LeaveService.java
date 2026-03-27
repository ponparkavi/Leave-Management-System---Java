package com.organisation.leaveManagement.service;
import com.organisation.leaveManagement.model.*;
import com.organisation.leaveManagement.repository.EmployeeRepository;
import com.organisation.leaveManagement.util.ValidationUtil;
import com.organisation.leaveManagement.exception.*;

public class LeaveService {
	private EmployeeRepository employeeRepository;
	
	public LeaveService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository ;
		
	}
	
	public void applyLeave(LeaveRequest request) throws EmployeeNotFoundException,
	InsufficientLeaveBalanceException,InvalidLeaveRequestException{
		
		//request validation 
		ValidationUtil.validateLeaveDays(request.getNumberOfDays());
		ValidationUtil.validateLeaveType(request.getLeaveType());
		ValidationUtil.validateString(request.getReason(),"Reason");
		
		EmployeeData employee = employeeRepository.findEmployeeById(request.getEmployeeId());
		
		//check employee exists:-
		if(employee == null){
			throw new EmployeeNotFoundException("Employee not found");
		}
		
		if(request.getLeaveType()==LeaveRequest.Leave.SICK && request.getNumberOfDays()>5) {
			throw new InvalidLeaveRequestException("Maximum 5 consecutive sick leaves allowed! ");
		}
		
		if(employee.getYearLeaveUsed() + request.getNumberOfDays() > 20){
		    throw new InvalidLeaveRequestException(
		        "Maximum 20 leave days allowed per year"
		    );
		}
	   // to check the leave balance
		if(request.getNumberOfDays() > employee.getLeaveBalance()) {
		    throw new InsufficientLeaveBalanceException("Not enough Leave balance!");
		}
	
		//deduct leave 
		int remaining = employee.getLeaveBalance() - request.getNumberOfDays();
		employee.setLeaveBalance(remaining);
		
		//update year count of leaves
		
		employee.setYearLeaveUsed(
	            employee.getYearLeaveUsed() + request.getNumberOfDays()
	    );

	}
	public void viewLeaveDetails(String empId) throws EmployeeNotFoundException {

	    EmployeeData employee = employeeRepository.findEmployeeById(empId);

	    if(employee == null){
	        throw new EmployeeNotFoundException("Employee not found");
	    }

	    System.out.println("Employee ID: " + employee.getEmployeeId());
	    System.out.println("Name: " + employee.getName());
	    System.out.println("Leave Taken: " + employee.getYearLeaveUsed());
	    System.out.println("Remaining Balance: " + employee.getLeaveBalance());
	}
	
}



