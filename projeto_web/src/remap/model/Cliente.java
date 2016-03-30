package remap.model;

import remap.dao.ClienteDAO;
import remap.to.ClienteTO;

public class Cliente {
	private int id;
	private String nome , fone;
	
	public Cliente(){
		this("","");
	}
	
	public Cliente(String nome, String fone) {
		this.nome = nome;
		this.fone = fone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public ClienteTO geraTO(){
		ClienteTO to = new ClienteTO();
		
		to.setId( getId() );
		to.setFone( getFone() );
		to.setNome( getNome() );
		
		return to;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void salvar(){
		ClienteDAO dao = new ClienteDAO();
		ClienteTO  to = new ClienteTO();
		
		to.setNome(getNome());
		to.setFone(getFone());
		
		setId( dao.salvar(to).getId() );
	}
	
	public void atualizar(){
		ClienteDAO dao = new ClienteDAO();
		ClienteTO  to = new ClienteTO();
		
		to.setNome(getNome());
		to.setFone(getFone());
		to.setId(getId());
		
		dao.atualizar(to);
		
	}
	
	
	
	public void excluir(){
		ClienteDAO dao = new ClienteDAO();
		
		dao.excluir( getId() );
	}
	
	public Cliente consultar(){
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = dao.consultar( getId() );
		
		setNome( to.getNome() );
		setFone( to.getFone() );
		
		return this;
	}
	
}
