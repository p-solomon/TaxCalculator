package data.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection conn = null;

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			if (conn == null) {
	            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3","root","root");  
			}
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
