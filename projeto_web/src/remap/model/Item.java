package remap.model;

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
	
	
}
