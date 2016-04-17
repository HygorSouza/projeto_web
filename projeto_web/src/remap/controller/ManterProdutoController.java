package remap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import remap.model.Produto;

/**
 * Servlet implementation class ManterProdutoController
 */
@WebServlet("/ManterProduto.do")
public class ManterProdutoController extends HttpServlet {
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
		String sCodigo   	= request.getParameter("codigo");
		String nome      	= request.getParameter("nome");
		String sPreco    	= request.getParameter("preco");
		String sQuantidade  = request.getParameter("quantidade");
		String descricao 	= request.getParameter("descricao");
		String acao      	= request.getParameter("acao");
		
		double valor = 0.0;
		int codigo = -1;
		int quantidade = 0;
		
		request.setCharacterEncoding("UTF-8");
		
	    try{
	    	valor = Double.parseDouble(sPreco);
	    }catch(Exception e){
	    	
	    }
	    
	    try{
	    	codigo = Integer.parseInt(sCodigo);
	    }catch(Exception e){
	    	
	    }
	    
	    try {
			quantidade = Integer.parseInt(sQuantidade);
		} catch (Exception e) {
			
		}
		
		
		Produto produto = new Produto(nome , descricao , valor , quantidade );
		
		RequestDispatcher view = null;
		
		if( acao.equals("salvar") ){
			produto.salvar();
			view = request.getRequestDispatcher("ListaDeProduto.do?key="+produto.getCodigo() );
			
		}else if( acao.equals("editar") ){
			produto.setCodigo(codigo);
			produto.consultar();
			view = request.getRequestDispatcher("alterar_produto.jsp");
			
		}else if( acao.equals("atualizar") ){
			produto.setCodigo(codigo);
			produto.atualizar();
			view = request.getRequestDispatcher("ListaDeProduto.do?key="+produto.getCodigo() );
			
		}else if( acao.equals("consultar") ){
			produto.setCodigo(codigo);
			produto.consultar();
			view = request.getRequestDispatcher("exibir_produto.jsp");
		
		}else if(  acao.equals("excluir") ){
			produto.setCodigo(codigo);
			produto.excluir();
			view = request.getRequestDispatcher("listar_produto.jsp");
		
		}
		
		request.setAttribute("produto", produto.geraTO() );
		
		
		
		view.forward(request, response);
	}

}
