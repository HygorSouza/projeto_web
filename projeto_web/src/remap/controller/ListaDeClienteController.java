package remap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String key = request.getParameter("key");
		int idCliente = 0;
		
		try{
			idCliente = Integer.parseInt(key);
		}catch(NumberFormatException e){
			
		}
		
		Vendedor vendedor = new Vendedor();
		List<ClienteTO> lista = null;
		
		if( idCliente > 0 ){
			lista = vendedor.listaDeClientes(idCliente);
		}else{
			
			lista = vendedor.listaDeClientes(key);
		}
		request.setAttribute("lista", lista );
		
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
