package com.service;
import java.sql.SQLException;

import com.dao.ValidationDao;
import com.dao.ValidationDaoImpl;
import com.exception.EmployeeNotFoundException;
import com.exception.ValidationException;

public class ValidationService {
	ValidationDao validationDao = new ValidationDaoImpl();

	public void validateUser(String username) throws SQLException, EmployeeNotFoundException {
		validationDao.validateUser(username);
	}

	public void validatePassword(String username, int password) throws SQLException, ValidationException {
		validationDao.validatePassword(username, password);	
	}

	public int getEmployeeId(String username) throws SQLException {
		return validationDao.getEmployeeId(username);
	}

	public String getPositionForEmployee(int employeeId) throws SQLException {
		return validationDao.getPositionForEmployee(employeeId);
	}

	

}
