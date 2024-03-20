package com.dao;

import java.sql.SQLException;

import com.exception.EmployeeNotFoundException;
import com.exception.ValidationException;

public interface ValidationDao {

	void validateUser(String username) throws SQLException, EmployeeNotFoundException;

	void validatePassword(String username, int password) throws SQLException, ValidationException;

	int getEmployeeId(String username) throws SQLException;

	String getPositionForEmployee(int employeeId) throws SQLException;


}
