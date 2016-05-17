package remap.model;

import java.util.List;

import remap.dao.ClienteDAO;
import remap.dao.ProdutoDAO;
import remap.to.ProdutoTO;

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
	
	
	public List<ProdutoTO> listaDeProdutos(String key) {
		ProdutoDAO dao = new ProdutoDAO();	
		List<ProdutoTO> lista = dao.listaDeProdutos(key);
		return lista;
	
	}
	
	public List<ProdutoTO> listaDeProdutos() {
		ProdutoDAO dao = new ProdutoDAO();	
		List<ProdutoTO> lista = dao.listaDeProdutos();
		return lista;
	
	}
	
	
}
