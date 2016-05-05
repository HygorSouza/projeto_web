package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Cliente;
import remap.to.ClienteTO;

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

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.excluir();

		HttpSession session = request.getSession();

		List<ClienteTO> list = (List<ClienteTO>) session.getAttribute("listaCliente");

		ClienteTO to;
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
