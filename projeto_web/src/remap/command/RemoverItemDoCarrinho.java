package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.CarrinhoDeCompra;

public class RemoverItemDoCarrinho implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sCodigo = request.getParameter("codigo");

		int codigo = -1;

		try {
			codigo = Integer.parseInt(sCodigo);

		} catch (NumberFormatException e) {

		}

		HttpSession session = request.getSession();

		CarrinhoDeCompra carrinhoDeCompra = (CarrinhoDeCompra) session.getAttribute("carrinhoDeCompra");

		carrinhoDeCompra.remove(codigo);

		if (carrinhoDeCompra.isEmpty())
			session.setAttribute("carrinhoDeCompra", null);
		else
			session.setAttribute("carrinhoDeCompra", carrinhoDeCompra);

		RequestDispatcher view = request.getRequestDispatcher("tela_venda.jsp");
		view.forward(request, response);

	}

}
