package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.VendedorService;
import remap.to.ProdutoTO;

public class ListarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");

		VendedorService vendedor = new VendedorService();
		List<ProdutoTO> lista = null;

		HttpSession session = request.getSession();

		if (key != null && key.length() > 0) {
			lista = vendedor.listaDeProdutos(key);
		} else {
			lista = vendedor.listaDeProdutos();
		}
		session.setAttribute("listaProduto", lista);

		RequestDispatcher view = request.getRequestDispatcher("listar_produto.jsp");
		view.forward(request, response);

	}

}
