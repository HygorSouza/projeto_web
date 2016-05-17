package remap.model;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome , fone;
	
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
	
}
