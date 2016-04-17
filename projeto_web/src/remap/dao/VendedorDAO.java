package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.to.ClienteTO;
import remap.to.ProdutoTO;

public class VendedorDAO {

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

	public List<ClienteTO> listaDeClientes(int idCliente) {
		List<ClienteTO> list = new ArrayList<ClienteTO>();

		ClienteTO to;
		String sqlSelect = "SELECT * FROM tb_cliente WHERE id_cliente = ?";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idCliente);
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

	
	public List<ProdutoTO> listaDeProdutos(String key) {
		List<ProdutoTO> lista = new ArrayList<ProdutoTO>();
		String sqlSelect = "SELECT * FROM tb_produto WHERE UPPER(nome_produto) LIKE ?";
		ProdutoTO to;
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString( 1, key.toUpperCase()+"%" );
			try (ResultSet rs = stm.executeQuery();) {

				while(rs.next()) {
					to  = new ProdutoTO();
					to.setCodigo(  rs.getInt("cod_produto"));
					to.setNome(rs.getString("nome_produto"));
					to.setPreco(rs.getDouble("preco"));
					to.setDescricao(rs.getString("descricao"));
					to.setQuantidadeEmEstoque( rs.getInt("quantidade") );
					to.setQuantidade( to.getQuantidadeEmEstoque() );
					lista.add(to);
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}
	
	public List<ProdutoTO> listaDeProdutos( int codigo ){
		List<ProdutoTO> lista = new ArrayList<ProdutoTO>(); 
		String sqlSelect = "SELECT * FROM tb_produto WHERE cod_produto = ?";
		ProdutoTO to;
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt( 1 , codigo );
			try(ResultSet rs = stm.executeQuery() ;){
				
				while( rs.next() ){
					to = new ProdutoTO();
					to.setCodigo( rs.getInt("cod_produto") );
					to.setNome(  rs.getString("nome_produto") );
					to.setPreco( rs.getDouble("preco") );
					to.setDescricao( rs.getString("descricao") );
					to.setQuantidadeEmEstoque( rs.getInt("quantidade") );
					to.setQuantidade( to.getQuantidadeEmEstoque() );
					lista.add(to);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}

}
