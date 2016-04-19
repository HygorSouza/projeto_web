package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
			stm.execute();
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
	
	
	// inicio -- metodos para obter uma lista de Clientes
	public List<ClienteTO> listaDeClientes(String key) {
		List<ClienteTO> list = new ArrayList<ClienteTO>();

		ClienteTO to;
		String sqlSelect = "SELECT * FROM tb_cliente WHERE UPPER(nome_cliente) LIKE ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, key.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new ClienteTO();
					to.setId(rs.getInt("id_cliente"));
					to.setNome(rs.getString("nome_cliente"));
					to.setFone(rs.getString("fone_cliente"));
					list.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<ClienteTO> listaDeClientes() {
		List<ClienteTO> list = new ArrayList<ClienteTO>();

		ClienteTO to;
		String sqlSelect = "SELECT * FROM tb_cliente";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new ClienteTO();
					to.setId(rs.getInt("id_cliente"));
					to.setNome(rs.getString("nome_cliente"));
					to.setFone(rs.getString("fone_cliente"));
					list.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	// fim -- metodos para obter uma lista de Clientes
	
}
