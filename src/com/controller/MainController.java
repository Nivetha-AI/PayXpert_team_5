package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.ValidationException;
import com.service.ValidationService;

public class MainController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ValidationService validationService = new ValidationService();
		System.out.println("Press 1. SIGN UP");
		System.out.println("Press 2. LOGIN");
		int option = sc.nextInt();
		switch(option) {
		case 1: 
			// sign up
			System.out.println("Enter your username:");
			String userName = sc.next();
			System.out.println("Create password: ");
			String password = sc.next();
			System.out.println("Retype password: ");
			String password1 = sc.next();
			
			if(!password.equals(password1)) {
				System.out.println("Password did not match");
				break;
			}
			
			System.out.println("Enter your role in the organization:");
			String role = sc.next();
			
			try {
				validationService.createUser(userName, password, role );
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to login ? (yes/no)");
			String opinion = sc.next();
			if(!opinion.equalsIgnoreCase("yes")) {
				break;
			}
			System.out.println();
			
		case 2:
			// login
			System.out.println("Enter your username:");
			userName = sc.next();

			try {
				validationService.validateUserName(userName);
				System.out.println("Enter your password: ");
				password = sc.next();

				validationService.validatePassword(userName, password);
				role = validationService.getUserRole(userName);
				if (role.equalsIgnoreCase("manager")) {
					System.out.println("Welcome " + userName);
					System.out.println();

					System.out.println("Press 1. To go to employee module");
					System.out.println("Press 2. To go to payroll module");
					System.out.println("Press 3. To go to tax module");
					System.out.println("Press 4. To go to financial record module");
					System.out.println("Press 0. To exit");

					System.out.println("Enter your choice: ");
					int input = sc.nextInt();

					if (input == 0) {
						System.out.println("Exiting all modules..Thank you!");
					}

					switch (input) {
					case 1:
						MEmployeeController.main(args);
						break;

					case 2:
						MPayrollController.main(args);
						break;

					case 3:
						MTaxController.main(args);
						break;

					case 4:
						MFinancialRecordController.main(args);
						break;

					default:
						System.out.println("Invalid Input");
						break;

					}

				} else {
					System.out.println("Welcome " + userName);
					System.out.println();

					System.out.println("Press 1. To go to employee module");
					System.out.println("Press 2. To go to payroll module");
					System.out.println("Press 3. To go to tax module");
					System.out.println("Press 4. To go to financial record module");
					System.out.println("Press 0. To exit");

					System.out.println("Enter your choice: ");
					int input = sc.nextInt();

					if (input == 0) {
						System.out.println("Exiting all modules..Thank you!");
					}

					switch (input) {
					case 1:
						EmployeeController.main(args);
						break;

					case 2:
						PayrollController.main(args);
						break;

					case 3:
						TaxController.main(args);
						break;

					case 4:
						FinancialRecordController.main(args);
						break;

					default:
						System.out.println("Invalid Input");
						break;

					}

				}
			} catch (ValidationException | SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
			
		default:
			System.out.println("Invalid option selected");
			break;
			
			
			
			
		}// switch closes
		sc.close();
	}

}
