package remap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.model.DadosVenda;
import remap.model.Item;
import remap.model.Produto;
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
	
	
	public List<DadosVenda> bucarVenda( int idCliente ){
		String sql = " SELECT * FROM tb_venda venda INNER JOIN tb_cliente cliente "
				+ " ON  venda.id_cliente = cliente.id_cliente    INNER JOIN tb_itens_venda itens "
				+ " ON itens.codigo_venda = venda.codigo_venda   INNER JOIN tb_produto  "
				+ " ON produto.cod_produto = itens.cod_produto"
				//+ " GROUP BY venda.codigo_venda "
				+ " WHERE cliente.id_cliente = ?";
	
		List<DadosVenda> lista = new ArrayList<DadosVenda>();
		DadosVenda to = new DadosVenda();
		
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, idCliente );
			
			try( ResultSet rs = stm.executeQuery(); ){
				while( rs.next() ){
					Venda venda = new Venda();
					
					Calendar c = Calendar.getInstance();
					c.setTime( new Date( Long.parseLong( rs.getString("data_venda") ) ) );
					venda.setData(c);
					
					venda.setIdCliente(idCliente);
					
					venda.setId( rs.getInt("tb_venda.codigo_venda") );
					
					to.setVenda(venda);
					
					Produto produto = new Produto();
					
					//produto.setCodigo( rs.getInt("cod_produto") );
					
					to.setProduto(produto);
					
					
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
			
		}catch( SQLException e ){
			e.printStackTrace();
		}
		
		return lista;
	}
	
}