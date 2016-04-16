package remap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remap.model.Cliente;

/**
 * Servlet implementation class ExcluirClienteController
 */
@WebServlet("/ExcluirCliente.do")
public class ExcluirClienteController extends HttpServlet {
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
		String sId = request.getParameter("id");
		int id = -1;
		
		try{
			id = Integer.parseInt(sId);
		}catch(NumberFormatException e){
			
		}
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.excluir();
		
		response.setStatus(200);
	}

}
