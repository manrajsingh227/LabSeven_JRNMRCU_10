package com.cg.eis.service;

import java.util.HashMap;
import java.util.Map;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDao;
import com.cg.eis.exception.InvalidIdException;
import com.cg.eis.exception.InvalidSalaryException;
import com.cg.eis.pl.Controller;

public class EmployeeServiceImpl implements IEmployeeService {
	public static Map<Integer, Employee> employeeList = new HashMap<Integer, Employee>();
	
	//creates employee object based on user input and stores object in hashMap
	@Override
	public Employee addDetails (int id, String name, int salary)  throws InvalidIdException, InvalidSalaryException{
			
			//throws exception for employee id less than 1
			if(id<1 || EmployeeDao.checkForId(id)) {
				throw new InvalidIdException("Invalid ID");
			}
		
			//throws exception for salary less than 1
			if(salary<1) {
				throw new InvalidSalaryException("Invalid Salary");
			}
		
			StringBuilder designation= new StringBuilder("");
			StringBuilder insuranceScheme = new StringBuilder("");
			
			//assigns designation and insuranceScheme based on salary
			if(salary<5000) {
				designation.append("Clerk");
				insuranceScheme.append("Not eligible");
			}
			else if(salary>5000 && salary<20000) {
				designation.append("System Associate");
				insuranceScheme.append("Scheme C");
			}
			else if(salary>=20000 && salary<40000) {
				designation.append("Programmer");
				insuranceScheme.append("Scheme B");
			}
			else if(salary>=40000) {
				designation.append("Manager");
				insuranceScheme.append("Scheme A");
			}
			
			//creates Employee object
			Employee e = new Employee(id, name, salary, designation.toString(), insuranceScheme.toString());
			
			//adds Employee to hashMap
			EmployeeDao.addToMap(e);
			return e;
	}

	//prints details of employee defined by viewID
	@Override
	public void viewDetails(int viewID) {
		
		//checks if employee exists
		if(EmployeeDao.checkForId(viewID)) {
			Controller.printEmployee(EmployeeDao.viewId(viewID));
		}
		else {
			System.out.println("Employee does not exist");
		}
	}

	//removes details of employee defined by removeID
	@Override
	public void removeDetails(int removeID) throws InvalidIdException {
		//checks if employee exists before removing		
		if(removeID<1 || !(EmployeeDao.checkForId(removeID))) {
			throw new InvalidIdException("Invalid ID");
		}
		
		else {
			EmployeeDao.removeId(removeID);
		}
				
	}

	//prints list of employees that avail scheme defined by user input
	@Override
	public void checkScheme(int choice) {
		
		//create scheme based on user choice
		StringBuilder scheme = new StringBuilder("");
		switch (choice) {
		case 1:
			scheme.append("Not eligible");
			break;
		
		case 2:
			scheme.append("Scheme A");
			break;
			
		case 3:
			scheme.append("Scheme B");
			break;
			
		case 4:
			scheme.append("Scheme C");
			break;
			
		default:
			System.out.println("Invalid Input");
			break;
		}
		
		EmployeeDao.viewScheme(scheme.toString());
	}
}
