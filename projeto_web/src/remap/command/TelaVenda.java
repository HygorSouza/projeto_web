package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Cliente;

public class TelaVenda implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		List<Cliente> lista = (List<Cliente>) session.getAttribute("listaCliente");
		
		Cliente to = lista.get( buscar( id , lista) );
		
		session.setAttribute("clienteVenda", to );
		
		
		RequestDispatcher view = request.getRequestDispatcher("tela_venda.jsp");
		view.forward(request, response);

	}
	
	public int buscar( int idCliente , List<Cliente> list ){
		Cliente to = null;
		for( int i = 0;i < list.size() ; i++ ){
			to = list.get(i);
			if( to.getId() == idCliente ){
				return i;
			}
		}
		
		return -1;
	}

}
