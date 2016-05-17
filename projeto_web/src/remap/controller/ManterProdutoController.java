package remap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.ProdutoService;
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
		request.setCharacterEncoding("UTF-8");
		
		String sCodigo   	= request.getParameter("codigo");
		String nome      	= request.getParameter("nome");
		String sPreco    	= request.getParameter("preco");
		String sQuantidade  = request.getParameter("quantidade");
		String descricao 	= request.getParameter("descricao");
		String acao      	= request.getParameter("acao");
		
		double preco = 0.0;
		int codigo = -1;
		int quantidade = 0;
		
		
		
	    try{
	    	preco = Double.parseDouble( sPreco.replace(',', '.' ) );
	    	
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
		
		
		ProdutoService produto = new ProdutoService(nome , descricao , preco , quantidade );
		
		RequestDispatcher view = null;
		
		produto.setCodigo(codigo);
		if( acao.equals("salvar") ){
			produto.salvar();
			
			List<Produto> list = new ArrayList<Produto>();
			list.add( produto.geraTO() );
			
			HttpSession session = request.getSession();
			
			session.setAttribute("listaProduto", list );
			view = request.getRequestDispatcher("listar_produto.jsp" );
			
		}else if( acao.equals("editar") ){
			
			produto.consultar();
			view = request.getRequestDispatcher("alterar_produto.jsp");
			
		}else if( acao.equals("atualizar") ){
			
			produto.atualizar();
			
			HttpSession session = request.getSession();
			
			List<Produto> list = (List<Produto>) session.getAttribute("listaProduto");
			
			Produto to;
			for(int i = 0 ; i < list.size() ; i++ ){
				to = list.get(i);
				
				if( to.getCodigo() == produto.getCodigo() ){
					
					to.setNome( produto.getNome() );
					to.setDescricao( produto.getDescricao() );
					to.setPreco( produto.getPreco() );
					
					break;
				}
			}
			
			session.setAttribute("listaProduto", list );
			
			view = request.getRequestDispatcher("listar_produto.jsp" );
			
		}else if( acao.equals("consultar") ){
			
			produto.consultar();
			view = request.getRequestDispatcher("exibir_produto.jsp");
		
		}else if(  acao.equals("excluir") ){
			
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
			
			view = request.getRequestDispatcher("listar_produto.jsp" );
		}
		
		request.setAttribute("produto", produto.geraTO() );
		
		
		
		view.forward(request, response);
	}

}
