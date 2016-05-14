package remap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import remap.model.CarrinhoDeCompra;
import remap.model.Item;
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
		request.setCharacterEncoding("UTF-8");
		
		String sCodigo     = request.getParameter("codigo");
		String sQuantidade = request.getParameter("quantidade");
		String acao    = request.getParameter("acao");
		int codigo     = -1;
		int quantidade = -1;
		
		boolean resultado = false;
		
		try{
			codigo = Integer.parseInt( sCodigo );
			
		}catch(NumberFormatException e){
			
		}
		
		try{
			quantidade = Integer.parseInt( sQuantidade );
			
		}catch(NumberFormatException e){
			
		}
	
		 
		Produto produto = new Produto(codigo);
		
		
		HttpSession session = request.getSession();
		
		CarrinhoDeCompra carrinhoDeCompra =  (CarrinhoDeCompra) session.getAttribute("carrinhoDeCompra");
		
		
		
		//
		if( acao.equals("adicionar") ){
			
			produto.consultar();
			
			if( produto.getNome() != null ){
				
				Item item =  new Item( produto , quantidade );
				
				// na primeira vez o if e executado
				if( carrinhoDeCompra == null ){
					
					carrinhoDeCompra = new CarrinhoDeCompra();
					
					resultado = carrinhoDeCompra.add(  item  );
				}
				else{ // para quando o objeto CarrinhoDeCompras ja estiver sido estanciado
					
					resultado = carrinhoDeCompra.add(  item );
				}
				
				// verifico se o produto foi adicionado com sucesso no carrinho
				if( !resultado ){
					request.setAttribute("produto", produto.geraTO() );
				}
				
				session.setAttribute("carrinhoDeCompra", carrinhoDeCompra );
			}
		}
		else if( acao.equals("remover") && quantidade != -1 ){

			carrinhoDeCompra.remove(codigo , quantidade );
			
			if( carrinhoDeCompra.isEmpty() )
				session.setAttribute("carrinhoDeCompra", null );
			else
				session.setAttribute("carrinhoDeCompra", carrinhoDeCompra );
		}
		else if( acao.equals("remover") ){

			carrinhoDeCompra.remove(codigo);
			
			if( carrinhoDeCompra.isEmpty() )
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
