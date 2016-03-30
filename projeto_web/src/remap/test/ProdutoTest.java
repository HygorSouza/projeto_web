package remap.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import remap.model.Produto;

public class ProdutoTest {
	Produto produto , copia ;
	
	@Before
	public void setUp() throws Exception {
		produto = new Produto("test", "test", 2.00 );
		copia = new Produto("test", "test", 2.00 );
	}

	@Test
	public void testSalvar() {
		produto.salvar();
		
		Produto p2 = produto.consultar();
		
		assertEquals("testa inclusao", produto , p2 );
	}

	@Test
	public void testAtualizar() {
		copia.setCodigo( produto.getCodigo() );
		copia.setNome("nome");
		produto.setNome("nome");
		produto.atualizar();
		produto.consultar();
		
		assertEquals("testa inclusao", copia , produto );
	}

	

	@Test
	public void testConsultar() {
		Produto p = new Produto();
		p.setCodigo( produto.getCodigo() );
		
		p.consultar();
		
		
		assertEquals("testa inclusao", p , produto );
	}
	
	@Test
	public void testExcluir() {
		Produto p = new Produto();
		p.setCodigo( produto.getCodigo() );
		
		produto.excluir();
		produto.consultar();
		
		assertEquals("testa inclusao", p , produto );
	}

}
