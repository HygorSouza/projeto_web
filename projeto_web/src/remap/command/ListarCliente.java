package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Cliente;
import remap.model.VendedorService;

public class ListarCliente implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String key = request.getParameter("key");

		HttpSession session = request.getSession();

		VendedorService vendedor = new VendedorService();
		List<Cliente> lista = null;

		if (key != null && key.length() > 0) {
			lista = vendedor.listaDeClientes(key);
		} else {

			lista = vendedor.listaDeClientes();
		}

		session.setAttribute("listaCliente", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("listar_cliente.jsp");
		dispatcher.forward(request, response);

	}

}
