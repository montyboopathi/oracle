package com.oracleTask;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.oracleLibrary.ListLogic;

public class ListService extends HttpServlet {
	private static Logger log = Logger.getLogger(ListService.class);
	int employeeID, Salary;
	String employeeName = "";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		Connection c = (Connection) ctx.getAttribute("mycon");
		log.info(c);
		try {
			BufferedReader br = request.getReader();
			JSONObject jo = Controller.RequestController(br);
			String s = jo.get("employeeID").toString();
			employeeID = Integer.parseInt(s);
			out.println(ListLogic.listEmployee(employeeID,c));
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
