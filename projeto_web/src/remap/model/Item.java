package remap.model;

import remap.to.ItemTO;
import remap.to.ProdutoTO;

public class Item {
	// atributos
	private ProdutoTO 	produto;
	private int       	quantidade;

	public Item( ProdutoTO produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public void setProduto( ProdutoTO to ){
		produto = to;
	}
	
	public ProdutoTO getProduto(){
		return produto;
	}
	
	public void setQuantidade(  int qtd ){
		quantidade = qtd;	
	}
	
	public int getQuantidade(){
		return quantidade;	
	}
	
	public ItemTO geraTO(){
		ItemTO to = new ItemTO();
		
		to.setProduto(produto);
		to.setQuantidade(quantidade);
		
		return to;
	}
	
}
