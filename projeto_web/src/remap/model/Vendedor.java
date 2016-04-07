package remap.model;

import java.util.List;

import remap.dao.VendedorDAO;
import remap.to.ClienteTO;

public class Vendedor {
	
	
	public List<ClienteTO> listaDeClientes(){
		VendedorDAO dao = new VendedorDAO();
		
		List<ClienteTO> lista = dao.listaDeClientes();
		
		return lista;
	}
	
}
