package remap.model;

import java.util.ArrayList;
import java.util.List;

import remap.to.ProdutoTO;

public class ItensDaVenda {
	List<ProdutoTO> itens ;
	
	public ItensDaVenda(){
		this.itens = new ArrayList<ProdutoTO>();
	}
	
	public void add( ProdutoTO to){
		int indece = buscarProdutoParecido( to.getCodigo() );
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
		int indece = buscarProdutoParecido( codigo );
		if( indece >= 0 ){
			this.itens.remove(indece);
		}
	}
	
	// ter
	public void remove( ProdutoTO  to ){
		System.out.println("Terminar implementação do metodo");
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
	
	private int buscarProdutoParecido( int codigo ){
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
