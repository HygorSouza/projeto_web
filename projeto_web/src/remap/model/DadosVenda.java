package remap.model;

import java.util.Calendar;

public class DadosVenda {
	private Calendar data;
	private int idCliente;
	private double valor;
	
	public DadosVenda(){}
	
	public DadosVenda( int idCliente ){
		setIdCliente(idCliente);
		setData(Calendar.getInstance());
		setValor(0.0);
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
