package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.to.ClienteTO;
import remap.to.ListaDeClienteTO;

public class VendedorDAO {

	public ListaDeClienteTO  listaDeClientes( String key ) {
		List<ClienteTO> list = new ArrayList<ClienteTO>() ;
		ListaDeClienteTO listaCliente = new ListaDeClienteTO();
		
		ClienteTO to;
		String sqlSelect = "SELECT * FROM tb_cliente WHERE UPPER(nome_cliente) LIKE ?";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){ 
			 stm.setString( 1 , key.toUpperCase()+"%" );
			try( ResultSet rs = stm.executeQuery(); ){
				 while( rs.next() ){
					 to = new ClienteTO();
					 to.setId( rs.getInt("id_cliente") );
					 to.setNome( rs.getString("nome_cliente") );
					 to.setFone( rs.getString("fone_cliente") );
					 list.add(to);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		listaCliente.setLista(list);
		
		return listaCliente;
	}

}
