package remap.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import remap.model.Produto;

public class ProdutoTest {
	static Produto produto , copia ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		produto = new Produto("test", "test", 2.00 );
		produto.salvar();
		copia = new Produto("test", "test", 2.00 );
	}

	@Test
	public void testSalvar() {
	
		
		copia.setCodigo(  produto.getCodigo() );
		
		assertEquals("testa inclusao", produto , copia );
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
