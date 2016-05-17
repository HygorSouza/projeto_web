package remap.model;

import remap.dao.UsuarioDAO;
import remap.to.UsuarioTO;

public class UsuarioService {
	private int    id;
	private String usuario , senha;
	private String cargo;
	
	public UsuarioService(){}
	
	public UsuarioService( String usuario , String senha  ){
		this.usuario = usuario;
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioService other = (UsuarioService) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public UsuarioTO geraTO(){
		UsuarioTO to = new UsuarioTO();
		
		to.setSenha(getSenha());
		to.setUsuario(getUsuario());
		to.setId(getId());
		to.setCargo( getCargo() );
		
		return to;
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
		UsuarioTO to = geraTO();
		
		dao.atualizar(to);
	}
	
	public UsuarioService consultar(){
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = dao.consultar( getId() );
		
		setUsuario( to.getUsuario() );
		//setCargo( to.getCargo() );
		setSenha( to.getSenha() );
		
		return this;
	}
	
}