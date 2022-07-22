package com.oracleLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateLogic {
	public static String createEmployee( int Salary, String employeeName, Connection c) {
		try {
			
			PreparedStatement ps = c.prepareStatement("INSERT INTO employee (employeeName,Salary) values(?,?)");
			
			ps.setString(1, employeeName);
			ps.setInt(2,Salary);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "created";
		
	}
}
