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
		if( indece < 0 ){
			itens.add(to);
		}
		else{
			
		}
	}
	
	private int buscarProdutoParecido( int codigo ){
		for(int i = 0 ; i < itens.size() ; i++ ){
			ProdutoTO to = itens.get(i);
			if( codigo == to.getCodigo() ){
				return i;
			}
			
		}
		return -1;
	}
	
	
}
