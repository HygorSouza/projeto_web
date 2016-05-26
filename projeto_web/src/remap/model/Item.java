package remap.model;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// atributos
	private Produto 	produto;
	private int       	quantidade;

	public Item( Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
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
	
	public double total(){
		return ( produto.getPreco() * quantidade );
	}
	
	
}
