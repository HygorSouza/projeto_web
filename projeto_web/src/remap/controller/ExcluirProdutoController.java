package remap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remap.model.Produto;

/**
 * Servlet implementation class ExcluirProdutoController
 */
@WebServlet("/ExcluirProduto.do")
public class ExcluirProdutoController extends HttpServlet {
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
		String sCodigo = request.getParameter("codigo");
		int codigo = -1;
		
		try {
			codigo = Integer.parseInt(sCodigo);
		} catch (NumberFormatException e) {
			
		}
		
		Produto produto = new Produto();
		
		produto.setCodigo(codigo);
		produto.excluir();
		
		response.setStatus(200);
	}

}
