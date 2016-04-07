package remap.model;

import java.util.ArrayList;
import java.util.List;

import remap.dao.ProdutoDAO;
import remap.to.ProdutoTO;

public class ItensVenda {
	private List<ProdutoTO> itens;
	
	public ItensVenda(){
		this.itens = new ArrayList<ProdutoTO>();
	}
	
	public boolean pesquisar( int codigo ){
		boolean flag = false;
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.consultar( codigo );
		to.setCodigo(codigo);
		
		if( to.getNome() != null ){
			itens.add(to);
			flag = true;
		}
		return flag;
	}

	public List<ProdutoTO> getItens(){
		return this.itens;
	}

	public void setItens(List<ProdutoTO> itens) {
		this.itens = itens;
	}
	
	
	
}
