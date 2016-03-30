package remap.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import remap.model.Cliente;


public class ClienteTest {
	Cliente cliente , copia;
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Bela Lugosi", "123456789" );
		copia = new Cliente("Bela Lugosi", "123456789" );
	}
	
	@Test
	public void test00Consultar() {
		Cliente cli = new Cliente("test","123");
		cli.salvar();
		Cliente c = new Cliente();
		c.setId(  cli.getId() );
		c.consultar();
		
		assertEquals("testa inclusao", c , cli );
	}
	
	
	@Test
	public void test01Salvar() {
		cliente.salvar();
		cliente.consultar();
		copia.setId( cliente.getId() );
		
		assertEquals("testa inclusao", copia , cliente );
	}

	@Test
	public void test02Atualizar() {
		cliente.setFone("123");
		copia.setFone("123");
		cliente.atualizar();
		assertEquals("testa inclusao", copia, cliente);
	}

	@Test
	public void tes03tExcluir() {
		Cliente c = new Cliente(null,null);
		c.setId(  cliente.getId() );
		cliente.excluir();
		cliente.consultar();
		assertEquals("testa inclusao", c , cliente );
	}



}
