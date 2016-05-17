package remap.to;

import remap.model.ProdutoService;

public class ItemTO {
	private ProdutoService 	produto;
	private int       	quantidade;
	
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

	
}
