package remap.model;

import remap.dao.ClienteDAO;

public class ClienteService {
	private Cliente data = new Cliente();
	
	public ClienteService(){
		this("","");
	}
	
	public ClienteService(String nome, String fone) {
		setNome(nome);
		setFone(fone);
	}

	public ClienteService(int id) {
		setId(id);
	}

	public int getId() {
		return data.getId();
	}

	public void setId(int id) {
		this.data.setId(id);
	}

	public String getNome() {
		return data.getNome();
	}

	public void setNome(String nome) {
		this.data.setNome(nome);;
	}

	public String getFone() {
		return data.getFone();
	}

	public void setFone(String fone) {
		this.data.setFone(fone);
	}
	
	public Cliente geraTO(){
		Cliente to = new Cliente();
		
		to.setId( data.getId() );
		to.setFone( data.getFone() );
		to.setNome( data.getNome() );
		
		return to;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data.getId();
		result = prime * result + ((data.getNome() == null) ? 0 : data.getNome().hashCode());
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
		ClienteService other = (ClienteService) obj;
		if (data.getId() != other.data.getId())
			return false;
		if (data.getNome() == null) {
			if (other.data.getNome() != null)
				return false;
		} else if (!data.getNome().equals(other.data.getNome()))
			return false;
		return true;
	}

	public void salvar(){
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(data);
	}
	
	public void atualizar(){
		ClienteDAO dao = new ClienteDAO();
		dao.atualizar(data);
	}
	
	
	
	public void excluir(){
		ClienteDAO dao = new ClienteDAO();
		
		dao.excluir( data.getId() );
	}
	
	public ClienteService consultar(){
		ClienteDAO dao = new ClienteDAO();
		Cliente to = dao.consultar( data.getId() );
		
		data.setNome( to.getNome() );
		data.setFone( to.getFone() );
		
		return this;
	}
	
}
