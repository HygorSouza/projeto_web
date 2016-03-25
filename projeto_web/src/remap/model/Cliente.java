package remap.model;

import remap.dao.ClienteDAO;
import remap.to.ClienteTO;

public class Cliente {
	private int id;
	private String nome , fone;
	
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
	
}
