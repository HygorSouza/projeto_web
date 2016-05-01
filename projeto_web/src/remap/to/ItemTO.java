package remap.to;

import remap.model.Produto;

public class ItemTO {
	private Produto 	produto;
	private int       	quantidade;
	
	public void setProduto( Produto to ){
		produto = to;
	}
	
	public Produto getProduto(){
		return produto;
	}
	
	public void setQuantidade(  int qtd ){
		quantidade = qtd;	
	}
	
	public int getQuantidade(){
		return quantidade;	
	}

	
}
