package remap.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Cliente;
import remap.to.ClienteTO;

public class SalvarCliente implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");

		Cliente cliente = new Cliente(nome, fone);

		cliente.salvar();

		HttpSession session = request.getSession();

		List<ClienteTO> list = new ArrayList<ClienteTO>();
		list.add(cliente.geraTO());

		session.setAttribute("listaCliente", list);
		RequestDispatcher view = request.getRequestDispatcher("listar_cliente.jsp");

		request.setAttribute("cliente", cliente.geraTO());

		view.forward(request, response);

	}

}
