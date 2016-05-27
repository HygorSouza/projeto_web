package remap.model;

import remap.dao.UsuarioDAO;

public class UsuarioService {
	private Usuario usuario = new Usuario();
	//private String cargo;
	
	public UsuarioService(){}
	
	public UsuarioService( String nome , String senha  ){
		setNome(nome);
		setSenha(senha);
	}

	public String getNome() {
		return usuario.getNome();
	}

	public void setNome(String nome) {
		this.usuario.setNome(nome);
	}

	public String getSenha() {
		return usuario.getSenha();
	}

	public void setSenha(String senha) {
		this.usuario.setSenha(senha);;
	}

	public int getId() {
		return usuario.getId();
	}

	public void setId(int id) {
		this.usuario.setId(id);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + usuario.getId();
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
		if (usuario.getId() != other.usuario.getId() )
			return false;
		return true;
	}

	public Usuario geraTO(){
		Usuario to = new Usuario();
		
		to.setSenha(usuario.getSenha());
		to.setNome(usuario.getNome() );
		to.setId(usuario.getId());
		
		return to;
	}
	
	public void salvar(){
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.salvar(usuario);
	}
	
	public void excluir(){
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.excluir( getId() );
	}
	
	public void atualizar(){
		UsuarioDAO dao = new UsuarioDAO();

		
		dao.atualizar(usuario);
	}
	
	public UsuarioService consultar(){
		UsuarioDAO dao = new UsuarioDAO();
		Usuario to = dao.consultar( usuario );
		usuario = to;
		
		return this;
	}

	public boolean validar() {
	 UsuarioDAO dao = new UsuarioDAO();
	 return dao.validar(usuario);
	}
	
}
