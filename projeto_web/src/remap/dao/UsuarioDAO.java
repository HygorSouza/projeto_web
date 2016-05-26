package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import remap.factory.ConnectionFactory;
import remap.model.Usuario;

public class UsuarioDAO {
	
	public Usuario salvar( Usuario to ){
		String sqlInsert = "INSERT INTO tb_usuario VALUES (?,?,?)";
		try( Connection conn = ConnectionFactory.getConnection(); 
			 PreparedStatement stm = conn.prepareStatement(sqlInsert); ){
			 
		     stm.setNull( 1 , Types.INTEGER );
			 stm.setString( 2 , to.getNome() );
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
	
	public void atualizar( Usuario to ){
		String sqlUpdate = "UPDATE tb_usuario SET nome_usuario = ?  WHERE  cod_usuario = ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate); ){
			stm.setString( 1 , to.getNome() );
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
	
	public Usuario consultar( int id ){
		String sqlSelect = "SELECT * FROM tb_usuario WHERE cod_usuario = ?";
		Usuario to = new Usuario();
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt( 1 , id );
			try( ResultSet rs = stm.executeQuery();){
				if( rs.next() ){
					to.setNome( rs.getString("nome_usuario") );
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
	
	public boolean validar( Usuario to ){
		String sqlSelect = "SELECT * FROM tb_usuario WHERE nome_usuario = ? AND senha_usuario = ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString( 1 , to.getNome() );
			stm.setString( 2 , to.getSenha() );
			try( ResultSet rs = stm.executeQuery();){
				if( rs.next() ){
					return true;
				}else{
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}