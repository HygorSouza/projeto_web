package remap.model;

import remap.dao.ProdutoDAO;
import remap.to.ProdutoTO;

public class Produto {
	private int codigo;
	private String nome  , descricao;
	private double preco;
	
	public Produto(){}

	public Produto(String nome , String descricao, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	public ProdutoTO geraTO(){
		ProdutoTO to = new ProdutoTO();
		
		to.setCodigo( getCodigo() );
		to.setNome( getNome() );
		to.setPreco( getPreco() );
		to.setDescricao( getDescricao() );
		
		return to;
		
	}
	
	
	public void salvar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		
		to.setNome( getNome() );
		to.setPreco( getPreco() );
		to.setDescricao( getDescricao() );
		
		setCodigo(  dao.salvar(to).getCodigo()  );
	}
	
	public void atualizar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		
		to.setNome  ( getNome()   );
		to.setPreco ( getPreco()  );
		to.setDescricao( getDescricao() );
		to.setCodigo( getCodigo() );
		
		dao.atualizar(to);
		
	}
	
	public void excluir(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		
		to.setCodigo( getCodigo() );
		
		dao.excluir(to);
		
	}
	
	public Produto consultar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.consultar(getCodigo());
		
		setNome( to.getNome() );
		setPreco( to.getPreco() );
		setDescricao( to.getDescricao() );
		
		return this;
	}
	
}
