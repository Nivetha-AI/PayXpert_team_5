package com.service;
import java.sql.SQLException;

import com.dao.ValidationDao;
import com.dao.ValidationDaoImpl;
import com.exception.ValidationException;

public class ValidationService {
	ValidationDao validationDao = new ValidationDaoImpl();

	public void validateUserName(String userName) throws ValidationException, SQLException {
		validationDao.validateUserName(userName);
	}

	public void validatePassword(String userName, String password) throws ValidationException, SQLException {
		validationDao.validatePassword(userName, password);
	}

	public String getUserRole(String userName) throws SQLException {
		return validationDao.getUserRole(userName);
	}

	public void createUser(String userName, String password, String role) throws SQLException {
		validationDao.createUser(userName, password, role);
	}

	

}
