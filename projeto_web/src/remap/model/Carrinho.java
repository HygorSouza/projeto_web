package remap.model;

import java.util.ArrayList;
import java.util.List;

import remap.to.ProdutoTO;

public class Carrinho {
	List<ProdutoTO> itens ;
	
	public Carrinho(){
		this.itens = new ArrayList<ProdutoTO>();
	}
	
	public List<ProdutoTO> getItens() {
		return itens;
	}
	
	public void add( ProdutoTO to ){
		int indece = buscar( to.getCodigo() );
		if( indece >= 0 ){
			juntarProdutoParecido( to , indece );
		}
		else{
			int qtd        = to.getQuantidade();
			int qtdEstoque = to.getQuantidadeEmEstoque();
			
			if( qtd <= qtdEstoque ){
				itens.add(to);
			}
		}
	}
	
	public void remove( int codigo ){
		int indece = buscar( codigo );
		if( indece >= 0 ){
			this.itens.remove(indece);
		}
	}
	
	public void remove( ProdutoTO to ){
		int indece = buscar( to.getCodigo() );
		
		if( indece >= 0 ){
			int qtd = to.getQuantidade();
			int qtdEstoque = itens.get(indece).getQuantidadeEmEstoque();
			
			if( qtd < qtdEstoque && qtd >= 0 ){
				
				ProdutoTO outro = itens.get(indece);
				itens.get(indece).setQuantidade( outro.getQuantidade() - to.getQuantidade() );
				
			}else if( qtd == qtdEstoque ){
			
				itens.remove(indece);
			}
			
		}
		
	}
	
	private void juntarProdutoParecido(ProdutoTO to , int indece ){
		ProdutoTO outro = this.itens.get(indece);
		int quantidadeTO    = to.getQuantidade();
		int quantidadeOutro = outro.getQuantidade();
		int novaQtd = quantidadeOutro + quantidadeTO;

		if( novaQtd <= to.getQuantidadeEmEstoque() ){
			this.itens.get(indece).setQuantidade(novaQtd);
		}
	}
	
	private int buscar( int codigo ){
		for(int i = 0 ; i < itens.size() ; i++ ){
			ProdutoTO to = itens.get(i);
			int cod = to.getCodigo();
			if( codigo == cod ){
				return i;
			}
			
		}
		return -1;
	}
	
	
}
