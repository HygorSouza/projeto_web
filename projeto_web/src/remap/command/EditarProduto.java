package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Produto;
import remap.model.ProdutoService;

public class EditarProduto implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sCodigo   = request.getParameter("codigo");

		int codigo = -1;
		
		try{
			codigo = Integer.parseInt(sCodigo);
		}catch( NumberFormatException e ){
			
		}
		
		ProdutoService produto = new ProdutoService(codigo);
		
		HttpSession session = request.getSession();
		
		List<Produto> lista = (List<Produto>) session.getAttribute("listaProduto");
		Produto to = null;
		
		for( int i = 0; i < lista.size(); i++ ){
			to = lista.get(i);
			if( to.getCodigo() == produto.getCodigo() ){
				break;
			}
		}

		request.setAttribute("produto", to );
		RequestDispatcher view = request.getRequestDispatcher("alterar_produto.jsp");
		
		view.forward(request, response);
	}

}
