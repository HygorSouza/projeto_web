package remap.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Produto;
import remap.to.ProdutoTO;

public class AtualizarProduto implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sCodigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String sPreco = request.getParameter("preco");
		String sQuantidade = request.getParameter("quantidade");
		String descricao = request.getParameter("descricao");

		double preco = 0.0;
		int codigo = -1;
		int quantidade = 0;

		try {
			preco = Double.parseDouble(sPreco.replace(',', '.'));

		} catch (Exception e) {

		}

		try {
			codigo = Integer.parseInt(sCodigo);
		} catch (Exception e) {

		}

		try {
			quantidade = Integer.parseInt(sQuantidade);
		} catch (Exception e) {

		}

		Produto produto = new Produto(nome, descricao, preco, quantidade);
		produto.setCodigo(codigo);

		produto.atualizar();

		HttpSession session = request.getSession();

		List<ProdutoTO> list = (List<ProdutoTO>) session.getAttribute("listaProduto");

		ProdutoTO to;
		for (int i = 0; i < list.size(); i++) {
			to = list.get(i);

			if (to.getCodigo() == produto.getCodigo()) {

				to.setNome(produto.getNome());
				to.setDescricao(produto.getDescricao());
				to.setPreco(produto.getPreco());

				break;
			}
		}

		session.setAttribute("listaProduto", list);

		RequestDispatcher view = request.getRequestDispatcher("listar_produto.jsp");

		view.forward(request, response);

	}

}
