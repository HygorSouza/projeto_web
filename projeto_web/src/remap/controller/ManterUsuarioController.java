package remap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remap.model.Usuario;

/**
 * Servlet implementation class ManterUsuarioController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuarioController extends HttpServlet {
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
		
		String sId   = request.getParameter("id");
		String nome  = request.getParameter("nome");
		//String cargo = request.getParameter("cargo");
		String acao  = request.getParameter("acao");
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			
		}
		
		Usuario user = new Usuario(nome,"password");
		
		if( acao.equals("salvar") ){
			user.salvar();
		}
		else if( acao.equals("atualizar") ){
			user.setId(id);
			user.atualizar();
		}
		else if(  acao.equals("excluir") ){
			user.setId(id);
			user.excluir();
		}else if(  acao.equals("consultar") ){
			user.setId(id);
			user.consultar();
		}
		
		request.setAttribute("usuario", user.geraTO() );
		
		RequestDispatcher view = request.getRequestDispatcher("usuario.jsp");
		view.forward(request,response);
		
	}

}
