package com.service;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeNotFoundException;
import com.model.Employee;

public class EmployeeService {
	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	public Employee getEmployeeById(int emid)throws SQLException,EmployeeNotFoundException {
		return employeeDao.getEmployeeById(emid);
	}
	public List<Employee> getAllEmployee() throws SQLException  {
		List <Employee> list = employeeDao.getAllEmployee();
		return list;
	}
	public void AddEmployee(Employee emp) throws SQLException{
		employeeDao.AddEmployee(emp);
	}
	
	public void updateEmployee(int eid, String efname, String elname, LocalDate edob, String egender, String eemail,
			String ephonenumber , String eaddress ,String eposition , 
			LocalDate ejoiningdate) throws SQLException , EmployeeNotFoundException {
		employeeDao.updateEmployee(eid , efname ,elname , edob , egender , eemail,
				ephonenumber ,  eaddress ,eposition , 
				 ejoiningdate );
		
	}
	public void deleteEmployee(int id) throws EmployeeNotFoundException, SQLException{
		employeeDao.deleteEmployee(id);
		
	}

	

}
