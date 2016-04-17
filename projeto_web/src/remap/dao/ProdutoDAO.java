package remap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import remap.factory.ConnectionFactory;
import remap.to.ProdutoTO;

public class ProdutoDAO {
	
	public ProdutoTO salvar( ProdutoTO to ){
		String sqlInsert = "INSERT INTO tb_produto VALUES ( ?, ?, ?, ?, ?)";
		try( Connection conn = ConnectionFactory.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			 stm.setNull( 1 , Types.INTEGER );
			 stm.setString( 2, to.getNome() );
			 stm.setDouble( 3, to.getPreco() );
			 stm.setString(4, to.getDescricao() );
			 stm.setInt( 5 , to.getQuantidade() );
			 stm.execute();
			 
			 to.setQuantidadeEmEstoque( to.getQuantidade() );
			 
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
		
		return to;
	}
	
	public void atualizar( ProdutoTO to ){
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
	
	public void excluir( ProdutoTO to ){
		String sqlDelete = "DELETE FROM tb_produto WHERE cod_produto = ? ";
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			
			stm.setInt(  1 , to.getCodigo() );
			stm.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public ProdutoTO consultar( int codigo ){
		String sqlSelect = "SELECT * FROM tb_produto WHERE cod_produto = ?";
		ProdutoTO to = new ProdutoTO();
		try( Connection conn = ConnectionFactory.getConnection() ;
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt( 1 , codigo );
			try(ResultSet rs = stm.executeQuery() ;){
				
				if( rs.next() ){
					to.setNome(  rs.getString("nome_produto") );
					to.setPreco( rs.getDouble("preco") );
					to.setDescricao( rs.getString("descricao") );
					to.setQuantidadeEmEstoque( rs.getInt("quantidade") );
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return to;
	}
	
}
