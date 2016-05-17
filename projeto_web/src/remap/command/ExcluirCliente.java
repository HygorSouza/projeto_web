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

public class ExcluirCliente implements Command {
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sId = request.getParameter("id");

		int id = -1;

		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {

		}

		ClienteService cliente = new ClienteService();
		cliente.setId(id);
		cliente.excluir();

		HttpSession session = request.getSession();

		List<Cliente> list = (List<Cliente>) session.getAttribute("listaCliente");

		Cliente to;
		for (int i = 0; i < list.size(); i++) {
			to = list.get(i);

			if (to.getId() == cliente.getId()) {
				list.remove(i);
				break;
			}

		}

		session.setAttribute("listaCliente", list);

		RequestDispatcher view = request.getRequestDispatcher("listar_cliente.jsp");

		view.forward(request, response);
	}

}
