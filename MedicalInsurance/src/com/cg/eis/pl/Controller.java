package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.InvalidIdException;
import com.cg.eis.exception.InvalidSalaryException;
import com.cg.eis.service.EmployeeServiceImpl;
import com.cg.eis.util.ScannerUtil;


public class Controller {
	
	//default constructor
	public Controller() {
		
	}
	
	//displays console
	public static void showConsole() {
		
		Scanner scanner =  ScannerUtil.getScanner();
		boolean flag = true;
		System.out.println("Welcome!");
		while(flag) {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Add new employee details");
			System.out.println("2. Delete employee details");
			System.out.println("3. View details of an existing employee");
			System.out.println("4. View employees availing a specific scheme");
			System.out.println("5. Exit");
			int choice = scanner.nextInt();
			
			
			//takes user choice
			switch (choice) {
			//Create and add Employee to hashMap
			case 1:
				EmployeeServiceImpl addEmp = new EmployeeServiceImpl();
				System.out.println("Enter the Employee ID");
				int id = scanner.nextInt();

				System.out.println("Enter the Employee Name");
				String name = scanner.next();
					
				System.out.println("Enter the Employee's salary");
				int salary = scanner.nextInt();
					

				try {
					addEmp.addDetails(id, name, salary);
				}catch(InvalidIdException m){
					System.out.println("Invalid ID exception: "+m);
				}
				catch(InvalidSalaryException n){
					System.out.println("Invalid Salary exception: "+n);
				}
				break;
				
				//deletes employee with mentioned id if it exists
				case 2:
					
					EmployeeServiceImpl deleteEmp = new EmployeeServiceImpl();
					
					System.out.println("Enter the ID of the employee");
					int removeID = scanner.nextInt();
					
					
				try {
					deleteEmp.removeDetails(removeID);
				} catch (InvalidIdException e) {
					e.printStackTrace();
				}
					break;
				
				//prints details of employee if it exists
				case 3:
					
					EmployeeServiceImpl viewEmp = new EmployeeServiceImpl();
					
					System.out.println("Enter the ID of the employee to view details");
					int viewID = scanner.nextInt();
					
					viewEmp.viewDetails(viewID);
					break;
					
				//checks for and prints details of employees with required scheme
				case 4:
					EmployeeServiceImpl viewScheme = new EmployeeServiceImpl();
					
					System.out.println("Which scheme would you like to check?");
					System.out.println("1. Not eligible");
					System.out.println("2. Scheme A");
					System.out.println("3. Scheme B");
					System.out.println("4. Scheme C");
					int num = scanner.nextInt();
					
					viewScheme.checkScheme(num);
					break;
				
				//ends program	
				case 5:
					flag = false;
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
			}
		}
	}
	
	//method to print employee info
	public static void printEmployee(Employee e) {
		
		System.out.println(e.toString());
	}

	//main method calls showConsole()
	public static void main(String[] args) {
		showConsole();
	}
}
