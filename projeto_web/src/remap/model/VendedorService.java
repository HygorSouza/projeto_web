package remap.model;

import java.util.List;

import remap.dao.ClienteDAO;
import remap.dao.ProdutoDAO;

public class VendedorService {
	
	public List<Cliente> listaDeClientes(){
		ClienteDAO dao = new ClienteDAO();
		
		List<Cliente> lista = dao.listaDeClientes();
		
		return lista;
	}
	
	public List<Cliente> listaDeClientes(String key){
		ClienteDAO dao = new ClienteDAO();
		
		List<Cliente> lista = dao.listaDeClientes(key);
		
		return lista;
	}
	
	
	public List<Produto> listaDeProdutos(String key) {
		ProdutoDAO dao = new ProdutoDAO();	
		List<Produto> lista = dao.listaDeProdutos(key);
		return lista;
	
	}
	
	public List<Produto> listaDeProdutos() {
		ProdutoDAO dao = new ProdutoDAO();	
		List<Produto> lista = dao.listaDeProdutos();
		return lista;
	
	}
	
	
}
