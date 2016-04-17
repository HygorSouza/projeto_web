package remap.model;

import java.util.List;

import remap.dao.VendedorDAO;
import remap.to.ClienteTO;
import remap.to.ProdutoTO;

public class Vendedor {
	
	public List<ClienteTO> listaDeClientes(int idCliente){
		VendedorDAO dao = new VendedorDAO();
		
		List<ClienteTO> lista = dao.listaDeClientes(idCliente);
		
		return lista;
	}
	
	public List<ClienteTO> listaDeClientes(String key){
		VendedorDAO dao = new VendedorDAO();
		
		List<ClienteTO> lista = dao.listaDeClientes(key);
		
		return lista;
	}
	
	
	public List<ProdutoTO> listaDeProdutos(String key) {
		VendedorDAO dao = new VendedorDAO();	
		
		return dao.listaDeProdutos(key);
	
	}
	
	public List<ProdutoTO> listaDeProdutos(int codigo) {
		VendedorDAO dao = new VendedorDAO();	
		
		return dao.listaDeProdutos(codigo);
	
	}
	
	
}
