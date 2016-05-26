package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.CarrinhoDeCompra;
import remap.model.ClienteService;
import remap.model.Item;
import remap.model.ProdutoService;

public class AdicionarItemNoCarrinho implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId         = request.getParameter("clienteVenda");
		String sCodigo     = request.getParameter("codigo");
		String sQuantidade = request.getParameter("quantidade");
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ClienteService cliente = new ClienteService(id);
		
		int codigo = -1;
		int quantidade = -1;

		boolean resultado = false;

		try {
			codigo = Integer.parseInt(sCodigo);

		} catch (NumberFormatException e) {

		}

		try {
			quantidade = Integer.parseInt(sQuantidade);

		} catch (NumberFormatException e) {

		}

		ProdutoService produto = new ProdutoService(codigo);

		HttpSession session = request.getSession();

		CarrinhoDeCompra carrinhoDeCompra = (CarrinhoDeCompra) session.getAttribute("carrinhoDeCompra");

		produto.consultar();

		if ( produto.getNome() != null ) {

			Item item = new Item(produto, quantidade);

			// na primeira vez o if e executado
			if ( carrinhoDeCompra == null ) {

				carrinhoDeCompra = new CarrinhoDeCompra();
				session.setAttribute("clienteVenda", cliente.geraTO() );

				resultado = carrinhoDeCompra.add(item);
			} else { // para quando o objeto CarrinhoDeCompras ja estiver sido
						// estanciado

				resultado = carrinhoDeCompra.add(item);
			}

			// verifico se o produto foi adicionado com sucesso no carrinho
			if ( !resultado ) {
				request.setAttribute("produto", produto.geraTO());
			}

			session.setAttribute("carrinhoDeCompra", carrinhoDeCompra);
		}

		RequestDispatcher view = request.getRequestDispatcher("tela_venda.jsp");
		view.forward(request, response);
	}

}
