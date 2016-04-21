package remap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.Cliente;
import remap.to.ClienteTO;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String sId  = request.getParameter("id");
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String acao = request.getParameter("acao");
		
		int id = -1;
		
		
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
		
		}
		
		Cliente cliente = new Cliente(nome, fone);
		RequestDispatcher view = null;
		
		if( acao.equals("salvar") ){
			cliente.salvar();
			
			HttpSession session = request.getSession();
			
			List<ClienteTO> list = new ArrayList<ClienteTO>();
			list.add( cliente.geraTO() );
			
			session.setAttribute("listaCliente", list );
			view = request.getRequestDispatcher("listar_cliente.jsp");
		}
		else if( acao.equals("atualizar") ){
			cliente.setId(id);
			cliente.atualizar();
			
			HttpSession session = request.getSession();
			List<ClienteTO> list = ( List<ClienteTO> ) session.getAttribute("listaCliente");
			
			ClienteTO to;
			for(int i = 0 ; i < list.size(); i++ ){
				to = list.get(i);
				
				if( to.getId() == cliente.getId() ){
					to.setNome( cliente.getNome() );
					to.setFone( cliente.getFone() );
					break;
				}
			}
			
			session.setAttribute("listaCliente", list);
			
			view = request.getRequestDispatcher("ListaDeCliente.do");
		}
		else if( acao.equals("editar") ){
			cliente.setId(id);
			cliente.consultar();
			view = request.getRequestDispatcher("alterar_cliente.jsp");
		}
		else if( acao.equals("excluir") ){
			cliente.setId(id);
			cliente.excluir();
			
			HttpSession session = request.getSession();
			
			List<ClienteTO> list = (List<ClienteTO>) session.getAttribute("listaCliente");
			
			ClienteTO to;
			for(int i = 0 ; i < list.size(); i++ ){
				to = list.get(i);
				
				if( to.getId() == cliente.getId() ){
					list.remove(i);
					break;
				}
				
			}
			
			session.setAttribute("listaCliente", list );
			
			view = request.getRequestDispatcher("listar_cliente.jsp");
		}
		else if(  acao.equals("consultar") ){
			cliente.setId(id);
			cliente.consultar();
			view = request.getRequestDispatcher("exibir_cliente.jsp");
		}
		
		request.setAttribute("cliente", cliente.geraTO() );
		
		
		view.forward(request,response);
		
	}

}
