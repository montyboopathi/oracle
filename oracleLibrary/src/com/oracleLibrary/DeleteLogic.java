package com.oracleLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLogic {
	public static String deleteEmployee(int employeeID, Connection c) {
		try {
			
			PreparedStatement ps = c.prepareStatement("DELETE  FROM employee where employeeID=?");
			ps.setInt(1, employeeID);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return (employeeID+" : Deleted");	
		
	}
}
