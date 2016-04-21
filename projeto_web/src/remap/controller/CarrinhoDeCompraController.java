package remap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Carrinho;
import remap.model.Produto;

/**
 * Servlet implementation class CarrinhoDeCompraController
 */
@WebServlet("/CarrinhoDeCompra.do")
public class CarrinhoDeCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sCodigo     = request.getParameter("codigo");
		String sQuantidade = request.getParameter("quantidade");
		String acao    = request.getParameter("acao");
		int codigo     = -1;
		int quantidade = 0;
		
		try{
			codigo = Integer.parseInt( sCodigo );
			
		}catch(NumberFormatException e){
			
		}
		
		try{
			quantidade = Integer.parseInt( sQuantidade );
			
		}catch(NumberFormatException e){
			
		}
	
		 
		Produto produto = new Produto(codigo);
		produto.setQuantidade(quantidade);

		
		HttpSession session = request.getSession();
		
		Carrinho carrinhoDeCompra =  (Carrinho) session.getAttribute("carrinhoDeCompra");
		
		if( acao.equals("adicionar") ){
			
			produto.consultar();
			
			if( produto.getNome() != null ){
				
				if( carrinhoDeCompra == null ){
					
					carrinhoDeCompra = new Carrinho();
					carrinhoDeCompra.add( produto.geraTO() );
				}
				else{
					
					carrinhoDeCompra.add( produto.geraTO() );
				}
				
				session.setAttribute("carrinhoDeCompra", carrinhoDeCompra );
			}
		}
		else if( acao.equals("remover") ){
			
			carrinhoDeCompra.remove(codigo);
			
			if( carrinhoDeCompra.size() == 0 )
				session.setAttribute("carrinhoDeCompra", null );
			else
				session.setAttribute("carrinhoDeCompra", carrinhoDeCompra );
		}
		else if( acao.equals("cancelar") ){
			session.setAttribute("carrinhoDeCompra", null );
		}
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("tela_venda.jsp");
		view.forward(request, response);
	}

}
