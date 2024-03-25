package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.ValidationException;
import com.util.DBUtil;

public class ValidationDaoImpl implements ValidationDao{

	@Override
	public void validateUserName(String userName) throws ValidationException , SQLException{
		Connection conn=DBUtil.getDBConn();
		String sql="select username from user";
		int flag = 0;
		String uName = null;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		while(rst.next()) { 
			uName = rst.getString("username");
			if(uName.equalsIgnoreCase(userName)) {
				flag =1;
			}
		}

		DBUtil.dbClose();
		if(flag ==0) {
			throw new ValidationException("Invalid Credentials");
		}
		
		
	}

	@Override
	public void validatePassword(String userName, String password) throws ValidationException , SQLException{
		Connection conn=DBUtil.getDBConn();
		String sql="select password from user where username = ?";
		int flag = 0;
		String passWord = null;
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		if(rst.next()) { 
			passWord = rst.getString("password");
			if(passWord.equalsIgnoreCase(password)) {
				flag =1;
			}
		}

		DBUtil.dbClose();
		if(flag ==0) {
			throw new ValidationException("Invalid Credentials");
		}
		
	}

	@Override
	public String getUserRole(String userName) throws SQLException{
		Connection conn=DBUtil.getDBConn();
		String sql="select role from user where username = ?";
		
		String role = null;
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		if(rst.next()) { 
			role = rst.getString("role");
			return role;
		}

		DBUtil.dbClose();
		return null;
	}

	@Override
	public void createUser(String userName, String password, String role) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into user values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		pstmt.executeUpdate();
		DBUtil.dbClose();
		
	}

	

}
