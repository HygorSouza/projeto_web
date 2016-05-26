package remap.model;

import remap.dao.ProdutoDAO;

public class ProdutoService {
	private Produto produto = new Produto();
	
	public ProdutoService(){}

	public ProdutoService(String nome , String descricao, double preco , int quantidade ) {
		this.setNome( nome);
		this.setPreco(preco);;
		this.setDescricao(descricao);
		this.setQuantidade(quantidade);
	}
	
	public ProdutoService(int codigo) {
		setCodigo(codigo);
	}

	public int getCodigo() {
		return produto.getCodigo();
	}

	public void setCodigo(int codigo) {
		this.produto.setCodigo(codigo);
	}

	public String getNome() {
		return produto.getNome();
	}

	public void setNome(String nome) {
		this.produto.setNome(nome);
	}

	public double getPreco() {
		return produto.getPreco();
	}

	public void setPreco(double preco) {
		this.produto.setPreco(preco);
	}
	
	public String getDescricao() {
		return produto.getDescricao();
	}

	public void setDescricao(String descricao) {
		this.produto.setDescricao(descricao);
	}
	
	public int getQuantidade() {
		return produto.getQuantidade();
	}

	public void setQuantidade(int quantidade) {
		this.produto.setQuantidade(quantidade);
	}



	public Produto geraTO(){
		return produto;
	}
	
	
	public void salvar(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
	}
	
	public void atualizar(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.atualizar(produto);
		
	}
	
	public void excluir(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(produto.getCodigo());
		
	}
	
	public ProdutoService consultar(){
		ProdutoDAO dao = new ProdutoDAO();
		Produto to = dao.consultar( produto.getCodigo() );
		produto = to;
		
		return this;
	}	
}
