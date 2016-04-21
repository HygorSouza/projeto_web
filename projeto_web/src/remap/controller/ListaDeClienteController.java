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
import remap.to.ClienteTO;

/**
 * Servlet implementation class ListaDeClienteController
 */
@WebServlet("/ListaDeCliente.do")
public class ListaDeClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key  = request.getParameter("key");
		String acao = request.getParameter("acao");
		
		HttpSession session = request.getSession();

		
		Vendedor vendedor = new Vendedor();
		List<ClienteTO> lista = null;
		
		if( acao.equals("buscar") ){
			if( key != null && key.length() > 0 ){
				lista = vendedor.listaDeClientes(key);
			}else{
				
				lista = vendedor.listaDeClientes();
			}
			session.setAttribute("listaCliente", lista );
		
		}else if( acao.equals("reiniciar") ){
			session.setAttribute("listaCliente", null );
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar_cliente.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
