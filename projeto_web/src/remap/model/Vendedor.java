package remap.model;

import java.util.List;

import remap.dao.ClienteDAO;
import remap.dao.ProdutoDAO;
import remap.to.ClienteTO;
import remap.to.ProdutoTO;

public class Vendedor {
	
	public List<ClienteTO> listaDeClientes(){
		ClienteDAO dao = new ClienteDAO();
		
		List<ClienteTO> lista = dao.listaDeClientes();
		
		return lista;
	}
	
	public List<ClienteTO> listaDeClientes(String key){
		ClienteDAO dao = new ClienteDAO();
		
		List<ClienteTO> lista = dao.listaDeClientes(key);
		
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
