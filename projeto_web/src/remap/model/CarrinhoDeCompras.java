package remap.model;


import java.util.ArrayList;
import java.util.List;

import remap.to.ProdutoTO;

public class CarrinhoDeCompras {
	private List<Item> itens;
	
	public int size(){
		return itens.size();
	}
	
	public List<Item> getItens(){
		return itens;
	}
	
	public CarrinhoDeCompras(){
		itens = new ArrayList<Item>();
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
			
			int qtd        = item.getQuantidade();
			int qtdEstoque = item.getProduto().getQuantidade();
			
			if( qtd <= qtdEstoque && qtd > 0 ){
				itens.add(item);
				resp = true;
			}
		}
		
		return resp;
	}
	
	public void remove( int codigo ){
		int indece = buscar( codigo );
		
		if( indece >= 0 ){
			this.itens.remove(indece);
		}
	}
	
	
	private boolean juntarItemParecido( Item item , int indece ){
		boolean resp = false;
		
		Item itemNaLista = itens.get(indece);
		int qtdEmEstoque  = itemNaLista.getProduto().getQuantidade();
		int novaQtd       = item.getQuantidade() + itemNaLista.getQuantidade();
		
		if( novaQtd <= qtdEmEstoque ){
			itemNaLista.setQuantidade(  novaQtd );
			resp = true;
		}
		
		return resp;
	}
	
	/*
	    metodo buscar retorna o indece onde se encontra um item 
	   ou -1 caso não encontrar um item com o codigo passado como parametro  
	  
	 */
	private int buscar( int codigo ){
		int indece = -1;
		for(int i = 0 ; i < itens.size() ; i++ ){
			ProdutoTO to = itens.get(i).getProduto();
			int cod = to.getCodigo();
			if( codigo == cod ){
				indece = i;
				break;
			}
			
		}
		return indece;
	}
	
}
