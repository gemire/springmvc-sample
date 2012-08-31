package com.dhenton9000.hibernate.concurrency.setup;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyCreate {

	/**
	 * @param args
	 * can be used to create a derby schema, that is a folder than can old databases
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:derby://localhost:1527/hibernate;create=true";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		
			Connection conn = 	 DriverManager.getConnection(url,"hibernate","hibernate");
		
		
		String t = conn.getCatalog();
		System.out.println("t "+t);
		
		conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   

		
		
		
		
	}

}
