package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datos  {
	static String driver="com.mysql.cj.jdbc.Driver";
	static String cadenaConexion="jdbc:mysql://localhost:3306/miscontactos?serverTimezone=UTC";
	static String user="root";
	static String password="root";
	static {
	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(cadenaConexion, user, password);
	}

}
