package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.InvalidIdException;
import com.cg.eis.exception.InvalidSalaryException;

public interface IEmployeeService {
	public Employee addDetails (int id, String Name, int salary) throws InvalidIdException, InvalidSalaryException;
	
	public void viewDetails(int viewID);
	
	public void removeDetails(int removeID) throws InvalidIdException;
	
	public void checkScheme(int choice);
}
