package remap.model;

import remap.dao.ProdutoDAO;

public class ProdutoService {
	private Produto data = new Produto();
	
	public ProdutoService(){}

	public ProdutoService(String nome , String descricao, double preco , int quantidade ) {
		this.setNome( nome);
		this.setPreco(preco);;
		this.setDescricao(descricao);
		this.setQuantidade(quantidade);
	}
	
	public ProdutoService(int codigo) {
		this.setCodigo(codigo);
	}

	public int getCodigo() {
		return data.getCodigo();
	}

	public void setCodigo(int codigo) {
		this.data.setCodigo(codigo);
	}

	public String getNome() {
		return data.getNome();
	}

	public void setNome(String nome) {
		this.data.setNome(nome);
	}

	public double getPreco() {
		return data.getPreco();
	}

	public void setPreco(double preco) {
		this.data.setPreco(preco);
	}
	
	public String getDescricao() {
		return data.getDescricao();
	}

	public void setDescricao(String descricao) {
		this.data.setDescricao(descricao);
	}
	
	public int getQuantidade() {
		return data.getQuantidade();
	}

	public void setQuantidade(int quantidade) {
		this.data.setQuantidade(quantidade);
	}



	public Produto geraTO(){
		Produto to = new Produto();
		
		to.setCodigo( data.getCodigo() );
		to.setNome( data.getNome() );
		to.setPreco( data.getPreco() );
		to.setDescricao( data.getDescricao() );
		to.setQuantidade( data.getQuantidade() );
		
		return to;
	}
	
	
	public void salvar(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(data);
	}
	
	public void atualizar(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.atualizar(data);
		
	}
	
	public void excluir(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(data);
		
	}
	
	public ProdutoService consultar(){
		ProdutoDAO dao = new ProdutoDAO();
		Produto to = dao.consultar( data.getCodigo() );
		
		setNome( to.getNome() );
		setPreco( to.getPreco() );
		setDescricao( to.getDescricao() );
		setQuantidade( to.getQuantidade() );
		
		return this;
	}	
}
