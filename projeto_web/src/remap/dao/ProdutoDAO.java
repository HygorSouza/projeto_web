package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import remap.factory.ConnectionFactory;
import remap.model.Produto;

public class ProdutoDAO {
	
	public void salvar( Produto to ){
		String sqlInsert = "INSERT INTO tb_produto VALUES ( ?, ?, ?, ?, ?)";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			 stm.setNull( 1 , Types.INTEGER );
			 stm.setString( 2, to.getNome() );
			 stm.setDouble( 3, to.getPreco() );
			 stm.setString(4, to.getDescricao() );
			 stm.setInt( 5 , to.getQuantidade() );
			 stm.execute();
			 
			 try( PreparedStatement stm2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
				  ResultSet rs = stm2.executeQuery(); ){
				 
				  if( rs.next() ){
					  to.setCodigo( rs.getInt(1) );
				  }
				 
			 }catch(SQLException e){
				 e.printStackTrace();
			 }
			 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void atualizar( Produto to ){
		String sqlUpdate = "UPDATE tb_produto SET nome_produto = ? , descricao = ? , preco = ? WHERE cod_produto = ?";
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			
			stm.setString( 1 , to.getNome()   );
			stm.setString( 2, to.getDescricao() );
			stm.setDouble( 3 , to.getPreco()  );
			stm.setInt   ( 4 , to.getCodigo() );
			stm.execute();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void excluir( int codigo ){
		String sqlDelete = "DELETE FROM tb_produto WHERE cod_produto = ? ";
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			
			stm.setInt(  1 , codigo );
			stm.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Produto consultar( int codigo ){
		String sqlSelect = "SELECT * FROM tb_produto WHERE cod_produto = ?";
		Produto to = new Produto();
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt( 1 , codigo );
			try(ResultSet rs = stm.executeQuery() ;){
				
				if( rs.next() ){
					to.setNome(  rs.getString("nome_produto") );
					to.setPreco( rs.getDouble("preco") );
					to.setDescricao( rs.getString("descricao") );
					to.setQuantidade( rs.getInt("quantidade") );
					to.setCodigo(codigo);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return to;
	}
	
	
	public List<Produto> listaDeProdutos(String key) {
		List<Produto> lista = new ArrayList<Produto>();
		String sqlSelect = "SELECT * FROM tb_produto WHERE UPPER(nome_produto) LIKE ?";
		Produto to;
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString( 1, key.toUpperCase()+"%" );
			try (ResultSet rs = stm.executeQuery();) {

				while(rs.next()) {
					to  = new Produto();
					to.setCodigo(  rs.getInt("cod_produto"));
					to.setNome(rs.getString("nome_produto"));
					to.setPreco(rs.getDouble("preco"));
					to.setDescricao(rs.getString("descricao"));
					to.setQuantidade( rs.getInt("quantidade") );
					
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
	
	public List<Produto> listaDeProdutos(){
		List<Produto> lista = new ArrayList<Produto>(); 
		String sqlSelect = "SELECT * FROM tb_produto";
		Produto to;
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			try(ResultSet rs = stm.executeQuery() ;){
				
				while( rs.next() ){
					to = new Produto();
					to.setCodigo( rs.getInt("cod_produto") );
					to.setNome(  rs.getString("nome_produto") );
					to.setPreco( rs.getDouble("preco") );
					to.setDescricao( rs.getString("descricao") );
					to.setQuantidade( rs.getInt("quantidade") );
					
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
