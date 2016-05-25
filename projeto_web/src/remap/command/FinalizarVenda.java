package remap.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.CarrinhoDeCompra;
import remap.model.VendaService;

public class FinalizarVenda implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sIdCliente = request.getParameter("id");
		int idCliente = 0;
		
		HttpSession session = request.getSession();
		
		try{
			idCliente = Integer.parseInt(sIdCliente);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		VendaService venda = new VendaService(idCliente);
		
		CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinhoDeCompra");
		
		venda.finalizarVenda(  carrinho.getItens() );
		
		session.setAttribute( "carrinhoDeCompra", null );
		
		
		RequestDispatcher view = request.getRequestDispatcher("tela_venda.jsp");
		view.forward(request, response);
	}

}
