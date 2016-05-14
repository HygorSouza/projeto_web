package remap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//private static ThreadLocal<Connection> conn = new ThreadLocal<>(); 

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
			String user = "alunos";
			String password = "alunos";
			String database = "remapbd_web";
			// conn.set(  );

		return DriverManager.getConnection( "jdbc:mysql://localhost:3306/"+database+"?user="+user+"&password="+password);
	}
	
	public static void closeConnection() throws SQLException{
		/*if( conn.get() != null ){
			conn.get().close();
			conn.set( null );
		}*/
		
	}
		
}
