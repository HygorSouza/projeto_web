package remap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		String user = "root";
		String password = "papagaio123";
		String database = "remapbd_web";
		return DriverManager.getConnection( "jdbc:mysql://localhost:3306/"+database+"?user="+user+"&password="+password);
		
	}
		
}
