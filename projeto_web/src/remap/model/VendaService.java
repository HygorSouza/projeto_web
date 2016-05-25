package remap.model;

import java.util.List;

import remap.dao.ItemDAO;
import remap.dao.VendaDAO;

public class VendaService {
	private Venda venda = new Venda();
	
	public VendaService( int idCliente ){
		setIdCliente(idCliente);
	}
	
	public int getId() {
		return venda.getId();
	}
	public void setId(int id) {
		this.venda.setId(id);
	}
	public int getIdCliente() {
		return venda.getIdCliente();
	}
	public void setIdCliente(int idCliente) {
		this.venda.setIdCliente(idCliente);
	}
	
	public void finalizarVenda( List<Item> lista ){
		VendaDAO dao = new VendaDAO();
		dao.finalizarVenda( venda );
		
		ItemDAO item = new ItemDAO();
		item.finalizarVenda( lista, getId() );
		item.atualizar(lista);
		
	}
	
	
}
