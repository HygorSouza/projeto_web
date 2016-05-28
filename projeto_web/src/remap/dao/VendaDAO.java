package remap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.model.Item;
import remap.model.Venda;

public class VendaDAO {
	
	public void finalizarVenda( Venda to , List<Item> lista ){
		String sqlInsert = "INSERT INTO tb_venda VALUES ( ?, ?, ?)";
		try( Connection conn = ConnectionFactory.getConnection(); 
			 PreparedStatement stm = conn.prepareStatement(sqlInsert); ){
			 
		     stm.setNull( 1 , Types.INTEGER );
			 stm.setInt( 2 , to.getIdCliente() );
			 stm.setDate( 3, new Date( to.getData().getTimeInMillis() ) );
			 stm.execute();
			 
			 try( PreparedStatement stm2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
				  ResultSet rs = stm2.executeQuery() ;){
				 if( rs.next() ){ 
					 to.setId( rs.getInt(1) );
					 ItemDAO dao = new ItemDAO();
					 dao.finalizarVenda(conn,lista, to.getId());
					 dao.atualizar(conn, lista);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}