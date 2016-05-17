package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.ProdutoService;
import remap.model.Produto;

public class ExcluirProduto implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sCodigo   	= request.getParameter("codigo");

		int codigo = -1;
		
	    
	    try{
	    	codigo = Integer.parseInt(sCodigo);
	    }catch(Exception e){
	    	
	    }		
		
		ProdutoService produto = new ProdutoService(codigo);

			produto.excluir();
			
			HttpSession session = request.getSession();
			
			List<Produto> list = (List<Produto>) session.getAttribute("listaProduto");
			
			Produto to;
			for(int i = 0 ; i < list.size() ; i++ ){
				to = list.get(i);
				
				if( to.getCodigo() == produto.getCodigo() ){
					list.remove(i);
					break;
				}
			}
			
			session.setAttribute("listaProduto", list );
			
			RequestDispatcher view = request.getRequestDispatcher("listar_produto.jsp" );

		view.forward(request, response);

	}

}
