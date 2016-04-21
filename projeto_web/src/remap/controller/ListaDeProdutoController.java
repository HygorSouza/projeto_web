package remap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Vendedor;
import remap.to.ProdutoTO;

/**
 * Servlet implementation class ListaDeProdutoController
 */
@WebServlet("/ListaDeProduto.do")
public class ListaDeProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String key  = request.getParameter("key");
		String acao = request.getParameter("acao");
		
		Vendedor vendedor = new Vendedor();
		List<ProdutoTO> lista = null;
		
		HttpSession session = request.getSession();
		
		if( acao.equals("buscar") ){		
			if( key != null  && key.length() > 0 ){
				lista = vendedor.listaDeProdutos(key);
			}else{
				lista = vendedor.listaDeProdutos();
			}
			session.setAttribute("listaProduto", lista );
		}
		else if( acao.equals("reiniciar") ){
			session.setAttribute("listaProduto", null );
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("listar_produto.jsp");
		view.forward(request, response);
		
	}

}
