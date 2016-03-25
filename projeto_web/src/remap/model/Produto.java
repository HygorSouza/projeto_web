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

	public ProdutoTO geraTO(){
		ProdutoTO to = new ProdutoTO();
		
		to.setCodigo( getCodigo() );
		to.setNome(getNome());
		to.setPreco(getPreco());
		
		return to;
		
	}
	
	
	public void salvar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		
		to.setNome( getNome() );
		to.setPreco( getPreco() );
		
		setCodigo(  dao.salvar(to).getCodigo()  );
	}
	
	public void atualizar(){
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		
		to.setNome  ( getNome()   );
		to.setPreco ( getPreco()  );
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
		ProdutoTO to = dao.carregar(getCodigo());
		
		setNome( to.getNome() );
		setPreco( to.getPreco() );
		
		return this;
	}
	
}
