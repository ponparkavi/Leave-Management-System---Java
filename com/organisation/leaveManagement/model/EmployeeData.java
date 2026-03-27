package com.organisation.leaveManagement.model;

public class EmployeeData {
	
	public EmployeeData(String employeeId, String name, int leaveBalance) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.leaveBalance = leaveBalance;
	}
	
	private int yearLeaveUsed = 0;
	private String employeeId;
	private String name;
	private int leaveBalance;
	
	public int getYearLeaveUsed() {
		return yearLeaveUsed;
	}
	public void setYearLeaveUsed(int yearLeaveUsed) {
		this.yearLeaveUsed = yearLeaveUsed;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	
	public int getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
}
