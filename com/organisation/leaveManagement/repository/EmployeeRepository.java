package com.organisation.leaveManagement.repository;

import java.util.HashMap;
import java.util.Map;
import com.organisation.leaveManagement.model.EmployeeData;

public class EmployeeRepository {
	private Map<String,EmployeeData> employeeMap = new HashMap<>();
	
	public void addEmployee(EmployeeData employee) {
		employeeMap.put(employee.getEmployeeId(), employee);
	}
	
	public EmployeeData findEmployeeById (String employeeId) {
		return employeeMap.get(employeeId);
	}
}




