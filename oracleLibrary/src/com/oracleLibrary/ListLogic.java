package com.oracleLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

public class ListLogic {
	public static JSONObject listEmployee(int employeeID,Connection c)  {
		JSONObject jobj =new JSONObject();
		try {
			
		String sql="SELECT * from EMPLOYEE WHERE employeeID=?";
    PreparedStatement	ps = c.prepareStatement(sql);
    	ps.setInt(1, employeeID);
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		jobj.put("Code",rs.getInt(1));
		jobj.put("NAME", rs.getString(2));
		jobj.put("Salary", rs.getInt(3));}
		return jobj;
	}
		catch(Exception e) {
			
		}
		return jobj;
	}
}
