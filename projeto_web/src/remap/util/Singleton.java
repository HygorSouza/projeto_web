package remap.util;

import java.sql.Connection;
import java.sql.SQLException;

import remap.factory.ConnectionFactory;

public class Singleton {
	private static Singleton instance = null;
	@SuppressWarnings("unused")
	private static Connection conn = null;
	
	private Singleton() throws SQLException {
		conn = ConnectionFactory.getConnection();
	}
	
	public static Singleton getInstance(){
		if( instance == null ){
			try {
				instance = new Singleton();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return instance;
	}
	
}
