package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CancelarVenda implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.setAttribute( "carrinhoDeCompra", null );
		
		session.setAttribute( "clienteVenda", null );
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
		
	}

}
