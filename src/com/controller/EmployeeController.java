package com.controller;

import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;

import com.exception.EmployeeNotFoundException;
import com.model.Employee;

import com.service.EmployeeService;

public class EmployeeController {
 public static void main(String[] args) {
	
	 	EmployeeService employeeService  = new EmployeeService ();  
	     Scanner sc = new Scanner(System.in);
	     while (true)
	     {
	     	System.out.println("************Employee Info System ************");
	     	System.out.println("Press 1. Get all the Employees by ID ");
	     	System.out.println("Press 2. to fetch all Employee records ");
	     	System.out.println("Press 3. to insert the Employee record ");
	     	System.out.println("Press 4. to Update all the employees record");
	     	System.out.println("press 5. to Delete the Employee record ");
//	        System.out.println("press 6. to ");
	     	System.out.println("Press 0. to Exit");
	     	System.out.println("**********************************************");
	     	
	     	int input = sc.nextInt();
	    
	     	if(input ==0) {
	     		System.out.println("Existing ... Thank You");
	     		break;
	     	}
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	     	switch(input){
	     	case 1:
	     		System.out.println("***SINGLE EMPLOYEE DETAILS");
				System.out.println("Enter employee Id : ");
				int emid = sc.nextInt();
				
				try {
					Employee e = employeeService.getEmployeeById(emid);
					System.out.println(e);
				} catch (SQLException e) {// if query goes wrong
					System.out.println(e.getMessage());
				}
				catch(EmployeeNotFoundException e) {// if id is invalid
					System.out.println(e.getMessage());
				}
	     		break;
	     		
    		case 2:
    			
    			try {
					List<Employee> list = employeeService.getAllEmployee();
					//Iterate over list
					System.out.println("**********ALL EMPLOYEES *********************");
	    			for (Employee e: list) {
	    		    	System.out.println(e.getId() + "  " + e.getFirstName()+ "  "+e.getLastName()
	    		    	+ " "+e.getDateOfBirth()+ " " +e.getGender() +" "+e.getEmail()+" "+e.getPhoneNum()+" "
	    		    	+e.getAddress()+ " "+ e.getPosition()+ " "+e.getJoiningDate()+ " "+e.getTerminationDate());
	    		    	
	    		    }
				} catch (SQLException  e) {
					System.out.println(e.getMessage());
				}
    			  			
    			break;
    			
    			
    			
    			
    		case 3:
             
    			System.out.println("Enter first name ");
    			sc.nextLine();
    			String firstName = sc.nextLine();
    			System.out.println("Enter last name ");
    			String lastName = sc.nextLine();
    			System.out.println("Enter DOB (YYYY-MM-DD): ");
    			String dateOfBirthStr = sc.next();
    	       
    	        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

    			System.out.println("Enter gender ");
    			String gender= sc .next();
    			System.out.println("Enter email");
    			String email= sc .next();
    			System.out.println("Enter phone Number");
    			String phoneNum= sc .next();
    			System.out.println("Enter Address ");
    			String address= sc .next();
    			System.out.println("Enter Position");
    			String position= sc .next();
    		
    			
    			// insert the record in db
    			Employee emp = new Employee( firstName, lastName,  dateOfBirth, gender,  email,
    					 phoneNum,  address,  position, LocalDate.now(),null) ;
    				
    			
    			try {
					employeeService.AddEmployee(emp);
					System.out.println("Employee inserted in DB");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
    			catch(Exception e){
    				System.out.println("Insertion error:"+ e.getMessage());
    			}	
					
    			break ;	
    			
						
    		case 4:
    			
    			System.out.println("Enter employee ID to update");
    			int eid = sc.nextInt();
    			System.out.println("Enter updated first name");
    			
    			String efname = sc.next();
    			System.out.println("Enter updated last name");
    			String elname = sc.next();
    			System.out.println("Enter updated dob : yyyy-mm-dd");
    			String edob1 = sc.next();
    			LocalDate edob = LocalDate.parse(edob1, formatter);
    			System.out.println("Enter updated gender");
    			String egender = sc.next();
    			System.out.println("Enter updated email ");
    			String eemail = sc.next();
    			System.out.println("Enter updated Phone number ");
    			String ephonenumber = sc.next();
    			System.out.println("Enter updated Address ");
    			String eaddress = sc.next();
    			System.out.println("Enter updated Position ");
    			String eposition = sc.next();
    			System.out.println("Enter updated joining date:yyyy-mm-dd  ");
    			String ejoiningdate1 = sc.next();
    			LocalDate ejoiningdate = LocalDate.parse(ejoiningdate1, formatter);
    			
    			 
    			try {
					employeeService.updateEmployee(eid , efname ,elname , edob , egender , 
							eemail,ephonenumber   ,eaddress,eposition , ejoiningdate );
					System.out.println("Record updated");
				} catch (SQLException | EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
    			
    			
    			break;
    		case 5:
    			// if 4 is pressed , we come here...
    			System.out.println("Enter Employee Id to Delete");
    			int id = sc.nextInt();
    			try {
					employeeService.deleteEmployee(id);
	                System.out.println("Employee Deleted");
				} catch (EmployeeNotFoundException | SQLException e) {
					System.out.println(e.getMessage());
				}
            
    			break;
    		default:
    			System.out.println("Invalid Input given..");
				break;

	     	}
	     
	     }// while ends
	     sc.close();
}// main ends
}// class ends

