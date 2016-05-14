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
			 //stm.setString( 4, to.getCargo() );
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
	
	public void atualizar( UsuarioTO to ){
		String sqlUpdate = "UPDATE tb_usuario SET nome_usuario = ?  WHERE  cod_usuario = ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate); ){
			stm.setString( 1 , to.getUsuario() );
			//stm.setString( 2 , to.getCargo() );
			stm.setInt( 2 , to.getId() );
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir( int id ){
		String sqlDelete = "DELETE FROM tb_usuario WHERE cod_usuario = ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt( 1 , id );
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public UsuarioTO consultar( int id ){
		String sqlSelect = "SELECT * FROM tb_usuario WHERE cod_usuario = ?";
		UsuarioTO to = new UsuarioTO();
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt( 1 , id );
			try( ResultSet rs = stm.executeQuery();){
				if( rs.next() ){
					to.setUsuario( rs.getString("nome_usuario") );
					//to.setCargo( rs.getString("cargo") );
					to.setSenha( rs.getString("senha_usuario") );
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