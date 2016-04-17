package remap.model;

import java.util.Calendar;

public class Venda {
	private int idCliente;
	private int codigo;
	private Calendar data;
	
	public Venda(int idCliente){
		setIdCliente( idCliente );
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	public void finalizarVenda(){
		
	}
	
}
