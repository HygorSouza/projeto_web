package remap.model;

import remap.to.ItemTO;


public class Item {
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
	
	public ItemTO geraTO(){
		ItemTO to = new ItemTO();
		
		to.setProduto(produto);
		to.setQuantidade(quantidade);
		
		return to;
	}
	
}
