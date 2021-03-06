package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.CarrinhoDeCompra;
import remap.model.Cliente;
import remap.model.VendaService;

public class FinalizarVenda implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Cliente cliente = (Cliente) session.getAttribute("clienteVenda");
		
		VendaService venda = new VendaService( cliente.getId() );
		
		CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinhoDeCompra");
		
		
		venda.finalizarVenda(  carrinho.getItens() );
		
		session.setAttribute( "carrinhoDeCompra", null );
		
		session.setAttribute( "clienteVenda", null );
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

}
