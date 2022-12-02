package com.bhavna.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnecClass {
	static Connection con;
	public static Connection createConnection() {
		try{
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user="root";
			String password="Bhavna@123";
			String url="jdbc:mysql://localhost:3306/organization";
			
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection established");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
