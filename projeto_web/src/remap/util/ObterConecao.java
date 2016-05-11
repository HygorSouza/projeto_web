package remap.util;

import java.sql.Connection;
import java.sql.SQLException;

import remap.factory.ConnectionFactory;

public class ObterConecao {
	private static ObterConecao instance = null;
	
	private static Connection conn = null;
	
	private ObterConecao() throws SQLException {
		conn = ConnectionFactory.getConnection();
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public static ObterConecao getInstance(){
		if( instance == null ){
			try {
				instance = new ObterConecao();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return instance;
	}
	
}
