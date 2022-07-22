package com.oracleTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.oracleLibrary.CreateLogic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateService extends HttpServlet {
	private static Logger log = Logger.getLogger(CreateService.class);
	
	int Salary;
	String employeeName;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		Connection c = (Connection) ctx.getAttribute("mycon");
		System.out.println(c);
		try {
			BufferedReader br = request.getReader();
			JSONObject jo = Controller.RequestController(br);

			String input2 = jo.get("employeeName").toString();
			String input3 = jo.get("Salary").toString();
			Salary = Integer.parseInt(input3);
			employeeName = input2;
			log.debug(Salary + " " + employeeName);

			out.println(CreateLogic.createEmployee(Salary, employeeName, c));

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
