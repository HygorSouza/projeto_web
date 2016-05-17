package remap.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import remap.model.ProdutoService;

public class ProdutoTest {
	static ProdutoService produto , copia ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		produto = new ProdutoService("test", "test", 2.00 , 10 );
		produto.salvar();
		copia = new ProdutoService("test", "test", 2.00  , 10 );
	}

	@Test
	public void testSalvar() {
	
		
		copia.setCodigo(  produto.getCodigo() );
		
		assertEquals("teste inclusao", produto , copia );
	}
	
	
	@Test
	public void testAtualizar() {
		copia.setCodigo( produto.getCodigo() );
		copia.setNome("nome");
		produto.setNome("nome");
		produto.atualizar();
		produto.consultar();
		
		assertEquals("teste de atualizacao", copia , produto );
	}

	

	@Test
	public void testConsultar() {
		ProdutoService p = new ProdutoService();
		p.setCodigo( produto.getCodigo() );
		
		p.consultar();
		
		
		assertEquals("teste consulta", p , produto );
	}
	
	@Test
	public void testExcluir() {
		ProdutoService p = new ProdutoService();
		p.setCodigo( produto.getCodigo() );
		
		produto.excluir();
		produto.consultar();
		
		assertEquals("teste para excluir produto", p , produto );
	}

}
