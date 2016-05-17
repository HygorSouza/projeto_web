package remap.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra  implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Item> itens;
	private double     valorTotal;
	
	// construtor
	public CarrinhoDeCompra(){
		itens = new ArrayList<Item>();
		valorTotal = 0.0;
	}
	
	public boolean isEmpty(){
		return itens.isEmpty();
	}
		
	public List<Item> getItens(){
		return itens;
	}
	
	public double getValorTotal(){
		return valorTotal;
	}
	
	/*  o metodo add retorna um boolean
    	true se foi adicionado com sucesso
    	ou false se o quantidade do item for maior da existe em estoque
	 */ 
	public boolean add( Item item ){
		boolean resp = false;
		
		int indece = buscar( item.getProduto().getCodigo() );
		
		if( indece >= 0 ){
			
			if( item.getQuantidade() > 0 )
				resp = juntarItemParecido( item , indece );
		}
		else{
			
			int quantidade  = item.getQuantidade();
			int qtdEstoque  = item.getProduto().getQuantidade();
			
			if( quantidade <= qtdEstoque && quantidade > 0 ){
				itens.add(item);
				atualizarValorTotal( item.total() );
				resp = true;
			}
		}
		
		return resp;
	}
	
	public boolean remove( int codigo ){
		boolean resp = false;
		int indece = buscar( codigo );
		
		if( indece >= 0 ){
			Item item = this.itens.remove(indece);
			atualizarValorTotal( - item.total() );
			resp = true;
		}
		return resp;
	}
	
	public boolean remove( int codigo , int qtd ){
		boolean resp = false;
		
		int indece = buscar( codigo );
		
		if( indece >= 0  ){
			Item item = this.itens.get(indece);
			if( item.getQuantidade() > 1 ){
				item.setQuantidade( -qtd );
				atualizarValorTotal( - item.total() );
				resp = true;
			}
		}
		
		return resp;
	}
	
	
	private boolean juntarItemParecido( Item item , int indece ){
		boolean resp = false;
		
		Item itemNaLista = itens.get(indece);
		int qtdEmEstoque  = itemNaLista.getProduto().getQuantidade();
		int novaQtd       = item.getQuantidade() + itemNaLista.getQuantidade();
		
		if( novaQtd <= qtdEmEstoque ){
			itemNaLista.setQuantidade(  novaQtd );
			atualizarValorTotal( item.total() );
			resp = true;
		}
		
		return resp;
	}
	
	private void atualizarValorTotal( double valor ){
		valorTotal += valor;
	}
	
	/*
	    metodo buscar retorna o indece onde se encontra um item 
	   ou -1 caso não encontrar um item com o codigo passado como parametro  
	  
	 */
	private int buscar( int codigo ){
		int indece = -1;
		for(int i = 0 ; i < itens.size() ; i++ ){
			ProdutoService to = itens.get(i).getProduto();
			int cod = to.getCodigo();
			if( codigo == cod ){
				indece = i;
				break;
			}
			
		}
		return indece;
	}
	
}
