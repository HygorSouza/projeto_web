package remap.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import remap.model.UsuarioService;
import remap.utils.CryptoException;
import remap.utils.CryptoUtils;

public class FazerLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		
		try {
			byte[] cripto = CryptoUtils.encrypt(CryptoUtils.chave, senha.getBytes("UTF-8"));
			senha = new String(cripto, "UTF-8");
		} catch (CryptoException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		UsuarioService usuarioService = new UsuarioService(nome, senha);
		HttpSession session = request.getSession();
		if(usuarioService.validar()){
			session.setAttribute("logado", usuarioService.geraTO());
			
			response.sendRedirect("home.jsp");
		} else {
			
			response.sendRedirect("index.jsp");
		}
		
	}

}
