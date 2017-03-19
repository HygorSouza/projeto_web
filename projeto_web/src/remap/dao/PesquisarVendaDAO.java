package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.model.DadosVenda;

public class PesquisarVendaDAO {

	public List<DadosVenda> bucarVenda( int idCliente ){
		String sql = " SELECT * FROM tb_venda venda INNER JOIN tb_cliente cliente "
				+ " ON  venda.id_cliente = cliente.id_cliente    INNER JOIN tb_itens_venda itens "
				+ " ON itens.codigo_venda = venda.codigo_venda   INNER JOIN tb_produto  "
				+ " ON produto.cod_produto = itens.cod_produto"
				//+ " GROUP BY venda.codigo_venda "
				+ " WHERE cliente.id_cliente = ?";
	
		List<DadosVenda> lista = new ArrayList<DadosVenda>();
		DadosVenda dados ;
		
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, idCliente );
			
			try( ResultSet rs = stm.executeQuery(); ){
				while( rs.next() ){
					dados = new DadosVenda();
					
					Calendar c = Calendar.getInstance();
					c.setTime( new Date(Long.parseLong(rs.getString("tb_venda.data_venda"))) );
					
					dados.setData( c );
					
					lista.add(dados);
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
