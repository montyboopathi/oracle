package com.oracleTask;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e) {

		System.out.println("connected");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
	        Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
	                               
		System.out.println(c);
		ServletContext context = e.getServletContext();
		context.setAttribute("mycon", c);
	} catch (Exception e1) {
		e1.printStackTrace();
	}
		
		}
	public void contextDestroyed(ServletContextEvent event) {
	}

}
