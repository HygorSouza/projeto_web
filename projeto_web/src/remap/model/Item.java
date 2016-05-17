package remap.model;

import remap.to.ItemTO;


public class Item {
	// atributos
	private ProdutoService 	produto;
	private int       	quantidade;

	public Item( ProdutoService produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public void setProduto( ProdutoService to ){
		produto = to;
	}
	
	public ProdutoService getProduto(){
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
