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

public class EditarCliente implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId  = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		ClienteService cliente = new ClienteService(id);
		
		HttpSession session = request.getSession();
		
		List<Cliente> lista = (List<Cliente>) session.getAttribute("listaCliente");
		Cliente to = null;
		
		for( int i = 0; i < lista.size(); i++ ){
			to = lista.get(i);
			if( to.getId() == cliente.getId() ){
				break;
			}
		}
		
		request.setAttribute("cliente", to );
		RequestDispatcher view = request.getRequestDispatcher("alterar_cliente.jsp");
		view.forward(request, response);

	}

}
