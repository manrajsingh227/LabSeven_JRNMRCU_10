package com.cg.eis.dao;

import java.util.HashMap;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.InvalidIdException;
import com.cg.eis.exception.InvalidSalaryException;
import com.cg.eis.pl.Controller;
import com.cg.eis.service.EmployeeServiceImpl;

public class EmployeeDao {
	
	//stores employee object in hashMap
	public static void addToMap(Employee e) throws InvalidIdException, InvalidSalaryException {
		EmployeeServiceImpl.employeeList.put(e.getId(), e);
	}
	
	//returns employee with the required ID
	public static Employee viewId(int empID) {
		return (EmployeeServiceImpl.employeeList.get(empID));
	}
	
	//removes all employees with the required ID
	public static void removeId(int removeID) {
		EmployeeServiceImpl.employeeList.remove(removeID);
	}
	
	//returns all employees with the required scheme
	public static void viewScheme(String scheme) {
		for(HashMap.Entry<Integer, Employee> entry : EmployeeServiceImpl.employeeList.entrySet()) {
			if(checkScheme(entry.getValue(), scheme)) {
				Controller.printEmployee(entry.getValue());
			}
		}
	}
	
	//checks if an employee avails a specified scheme
	public static boolean checkScheme(Employee e, String scheme){

		if(e.getInsuranceScheme().equals(scheme)) {
			return true;
		}
		else
			return false;
	}
	
	////return true if mentioned employee id exists
	public static boolean checkForId(int id) {
		if(EmployeeServiceImpl.employeeList.containsKey(id)) {
			return true;
		}
		else 
			return false;
	}
}
