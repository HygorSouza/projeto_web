package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import remap.model.Cliente;

public class EditarCliente implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId  = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		Cliente cliente = new Cliente();
		
		cliente.setId(id);
		cliente.consultar();
		request.setAttribute("cliente", cliente.geraTO() );
		RequestDispatcher view = request.getRequestDispatcher("alterar_cliente.jsp");
		view.forward(request, response);

	}

}
