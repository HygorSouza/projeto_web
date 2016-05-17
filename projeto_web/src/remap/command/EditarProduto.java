package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remap.model.ProdutoService;

public class EditarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sCodigo   = request.getParameter("codigo");

		int codigo = -1;
		
		try{
			codigo = Integer.parseInt(sCodigo);
		}catch( NumberFormatException e ){
			
		}
		
		ProdutoService produto = new ProdutoService(codigo);
		
		produto.consultar();
		request.setAttribute("produto", produto.geraTO() );
		RequestDispatcher view = request.getRequestDispatcher("alterar_produto.jsp");
		
		view.forward(request, response);
	}

}
