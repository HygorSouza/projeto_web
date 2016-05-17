package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Cliente;
import remap.model.ClienteService;

public class AtualizarCliente implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");

		int id = -1;

		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {

		}

		ClienteService cliente = new ClienteService(nome, fone);

		cliente.setId(id);
		cliente.atualizar();

		HttpSession session = request.getSession();
		List<Cliente> list = (List<Cliente>) session.getAttribute("listaCliente");

		Cliente to;
		for (int i = 0; i < list.size(); i++) {
			to = list.get(i);

			if (to.getId() == cliente.getId()) {
				to.setNome(cliente.getNome());
				to.setFone(cliente.getFone());
				break;
			}
		}


		session.setAttribute("listaCliente", list);

		RequestDispatcher view = request.getRequestDispatcher("listar_cliente.jsp");

		view.forward(request, response);

	}

}
