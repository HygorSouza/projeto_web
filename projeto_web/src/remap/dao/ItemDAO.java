package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.model.Item;

public class ItemDAO {
	
	public void finalizarVenda( List<Item> lista , int codigoVenda  ){
		String sqlInsert = "INSERT INTO tb_itens_venda VALUES ( ?, ?, ?)";
		try( Connection conn = ConnectionFactory.getConnection(); 
			 PreparedStatement stm = conn.prepareStatement(sqlInsert); ){
			 
				for( int i = 0 ; i < lista.size(); i++ ){
					Item item = lista.get(i);
					
					stm.setInt( 1 , codigoVenda );
			 		stm.setInt( 2 , item.getProduto().getCodigo() );
			 		stm.setInt( 3,  item.getQuantidade() );
			 		stm.execute();
				}
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar( List<Item> lista ){
		String sqlUpdate = "UPDATE tb_produto SET quantidade = ?  WHERE cod_produto = ?";
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			
			for( int i = 0 ; i < lista.size(); i++ ){
				
				Item item = lista.get(i);
		 		stm.setInt( 1,  item.getProduto().getQuantidade() - item.getQuantidade() );
		 		stm.setInt( 2 , item.getProduto().getCodigo() );
		 		stm.execute();
			
			}

			
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
