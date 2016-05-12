package remap.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Produto;
import remap.to.ProdutoTO;

public class SalvarProduto implements Command {

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

		produto.salvar();

		List<ProdutoTO> list = new ArrayList<ProdutoTO>();
		list.add(produto.geraTO());

		HttpSession session = request.getSession();

		session.setAttribute("listaProduto", list);
		
		RequestDispatcher view = request.getRequestDispatcher("listar_produto.jsp");


		view.forward(request, response);
	}

}
