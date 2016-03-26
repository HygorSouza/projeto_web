package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import remap.factory.ConnectionFactory;
import remap.to.ClienteTO;

public class ClienteDAO {
	
	public ClienteTO salvar( ClienteTO to ){
		String sqlInsert = "INSERT INTO tb_cliente VALUES (?,?,?)";
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setNull( 1 , Types.INTEGER );
			stm.setString( 2 , to.getNome() );
			stm.setString( 3 ,  to.getFone() );
			stm.execute();
			try( PreparedStatement stm2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
				 ResultSet rs = stm2.executeQuery();){
				 if( rs.next() ){
					 to.setId( rs.getInt(1) );
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
	public void atualizar( ClienteTO to ){
		String sqlUpdate = "UPDATE tb_cliente SET nome_cliente = ? , fone_cliente = ? WHERE id_cliente = ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString( 1 , to.getNome() );
			stm.setString( 2 , to.getFone() );
			stm.setInt( 3 , to.getId() );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir( int id ){
		String sqlDelete = "DELETE FROM tb_cliente WHERE id_cliente = ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete) ;){
			stm.setInt( 1 , id );
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ClienteTO consultar( int id ){
		ClienteTO to = new ClienteTO();
		String sqlSelect = "SELECT * FROM tb_cliente WHERE id_cliente = ?";
		try( Connection conn = ConnectionFactory.getConnection(); 
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			stm.setInt( 1 , id );
			
			try(ResultSet rs = stm.executeQuery();){
				if( rs.next() ){
					to.setNome( rs.getString("nome_cliente") );
					to.setFone( rs.getString("fone_cliente"));
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
