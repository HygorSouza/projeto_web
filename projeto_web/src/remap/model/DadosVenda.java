package remap.model;

public class DadosVenda {
	
	private Venda  venda;
	private Produto produto;
	private Cliente cliente;
	
	public DadosVenda(){}
	
	public DadosVenda( Cliente to ){
		setCliente(to);
	}
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
