package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
