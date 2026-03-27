package com.organisation.leaveManagement.main;
import com.organisation.leaveManagement.model.*;
import com.organisation.leaveManagement.exception.*;
import com.organisation.leaveManagement.repository.EmployeeRepository;
import com.organisation.leaveManagement.service.*;
import java.time.LocalDate;
import java.util.Scanner;

public class LeaveManagementApplication {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		EmployeeRepository repo = new EmployeeRepository();		
		LeaveService service = new LeaveService(repo);
		
        while(true){

            System.out.println("\n1. Add Employee");
            System.out.println("2. Apply Leave");
            System.out.println("3. View Leave Details");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice:(eg, 1)");
            int choice = s.nextInt();
            s.nextLine();

            try {

                switch(choice){

                    case 1:
                        System.out.print("Enter ID: ");
                        String id = s.nextLine();

                        System.out.print("Enter Name: ");
                        String name = s.nextLine();
                        repo.addEmployee(new EmployeeData(id,name,20));
                        System.out.println("Employee Added!");
                        break;

                    case 2:
                        System.out.print("Enter Employee ID: ");
                        String employeeId = s.nextLine();

                        System.out.print("Enter Leave Type ( SICK / CASUAL / EARNED ) : ");
                        String type = s.nextLine();

                        LeaveRequest.Leave leaveType;

                        try {
                            leaveType = LeaveRequest.Leave.valueOf(type.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid Leave Type!");
                            break;
                        }
                        
                        System.out.print("Enter Number of Days: ");
                        int days = s.nextInt();
                        s.nextLine();

                        System.out.print("Enter Reason: ");
                        String reason = s.nextLine();
                		LeaveRequest request = new LeaveRequest(employeeId, leaveType,days,reason,LocalDate.now());	
                        service.applyLeave(request);

                        System.out.println("Leave Applied Successfully!");
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        String viewId = s.nextLine();
                        service.viewLeaveDetails(viewId);
                        
                        break;

                    case 4:
                    	System.out.println("Exiting...");
                    	s.close();
                        System.exit(0);
                        
                    default:
                    	System.out.println("Invalid Choice");
                }

	        }
			
	        catch(InvalidLeaveRequestException e) {
				System.out.println("Invalid request: "+e.getMessage());
			}
			catch(InsufficientLeaveBalanceException e) {
				System.out.println("Balance error: " +e.getMessage());
			}
			catch(EmployeeNotFoundException e) {
				System.out.println("Employee error: "+e.getMessage());
			}
            
        }
        
	}
}


