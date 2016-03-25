package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import remap.factory.ConnectionFactory;
import remap.to.UsuarioTO;

public class UsuarioDAO {
	
	public UsuarioTO salvar( UsuarioTO to ){
		String sqlInsert = "INSERT INTO tb_usuario VALUES (?,?,?)";
		try( Connection conn = ConnectionFactory.getConnection(); 
			 PreparedStatement stm = conn.prepareStatement(sqlInsert); ){
			 
		     stm.setNull( 1 , Types.INTEGER );
			 stm.setString( 2 , to.getUsuario() );
			 stm.setString( 3 , to.getSenha() );
			 stm.execute();
			 
			 try( PreparedStatement stm2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
				  ResultSet rs = stm2.executeQuery() ;){
				
				 if( rs.next() ){
					 to.setId(  rs.getInt(1) );
				 }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
}