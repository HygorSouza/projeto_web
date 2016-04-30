package remap.to;

public class ItemTO {
	private ProdutoTO 	produto;
	private int       	quantidade;
	
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
	
}
