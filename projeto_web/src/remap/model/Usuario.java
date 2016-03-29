package remap.model;

import remap.dao.UsuarioDAO;
import remap.to.UsuarioTO;

public class Usuario {
	private int    id;
	private String usuario , cargo , senha;
	
	public Usuario(){}
	
	public Usuario( String usuario, String cargo ,String senha  ){
		this.usuario = usuario;
		this.cargo = cargo;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void salvar(){
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = new UsuarioTO();
		
		to.setUsuario( getUsuario() );
		to.setSenha( getSenha() );
		to.setCargo( getCargo() );
		
		setId(  dao.salvar(to).getId() );
	}
	
	public void excluir(){
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.excluir( getId() );
	}
	
	public void atualizar(){
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = new UsuarioTO();
		
		to.setId( getId() );
		to.setUsuario( getUsuario() );
		to.setSenha( getSenha() );
		to.setCargo( getCargo() );
		
		dao.atualizar(to);
	}
	
	public Usuario consultar(){
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = dao.consultar( getId() );
		
		setUsuario( to.getUsuario() );
		setCargo( to.getCargo() );
		setSenha( to.getSenha() );
		
		return this;
	}
	
}
