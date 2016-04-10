package remap.model;

import remap.dao.VendedorDAO;
import remap.to.ListaDeClienteTO;

public class Vendedor {
	
	
	public ListaDeClienteTO listaDeClientes(String key){
		VendedorDAO dao = new VendedorDAO();
		
		ListaDeClienteTO lista = dao.listaDeClientes(key);
		
		return lista;
	}
	
}
