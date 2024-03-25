package com.dao;

import java.sql.SQLException;

import com.exception.ValidationException;

public interface ValidationDao {

	void validateUserName(String userName) throws ValidationException, SQLException;

	void validatePassword(String userName, String password) throws ValidationException, SQLException;

	String getUserRole(String userName) throws SQLException;

	void createUser(String userName, String password, String role) throws SQLException;

	

}
