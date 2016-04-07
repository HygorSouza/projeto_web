package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.to.ClienteTO;

public class VendedorDAO {

	public List<ClienteTO> listaDeClientes() {
		List<ClienteTO> lista = new ArrayList<ClienteTO>() ;
		ClienteTO to;
		String sqlSelect = "SELECT * FROM tb_cliente";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect); 
			 ResultSet rs = stm.executeQuery();){
			 while( rs.next() ){
				 to = new ClienteTO();
				 to.setId( rs.getInt("id_cliente") );
				 to.setNome( rs.getString("nome_cliente") );
				 to.setFone( rs.getString("fone_cliente") );
				 lista.add(to);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
