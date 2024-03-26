package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.EmployeeDaoImpl;
import com.dto.EmployeeReportData;
import com.exception.EmployeeNotFoundException;
import com.exception.FinancialRecordException;
import com.model.Employee;

public class EmployeeService {
	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public Employee getEmployeeById(int emid) throws SQLException, EmployeeNotFoundException {
		return employeeDao.getEmployeeById(emid);
	}

	public List<Employee> getAllEmployee() throws SQLException, EmployeeNotFoundException {
		List<Employee> list = employeeDao.getAllEmployee();
		return list;
	}

	public void addEmployee(Employee emp) throws SQLException, EmployeeNotFoundException {
		employeeDao.addEmployee(emp);
	}

	public void updateEmployee(int eid, String efname, String elname, LocalDate edob, String egender, String eemail,
			String ephonenumber, String eaddress, String eposition, LocalDate ejoiningdate)
			throws SQLException, EmployeeNotFoundException {
	 employeeDao.updateEmployee(eid, efname, elname, edob, egender, eemail, ephonenumber, eaddress, eposition,
				ejoiningdate);

	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException, SQLException {
		employeeDao.deleteEmployee(id);

	}

	public List<EmployeeReportData> getReport(int empid, int fyear) throws SQLException, FinancialRecordException {
		List<EmployeeReportData> list = employeeDao.getReport(empid, fyear);

		return list;
	}

}
