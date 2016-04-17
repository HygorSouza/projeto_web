package remap.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import remap.model.Cliente;


public class ClienteTest {
	static Cliente cliente , copia;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cliente = new Cliente("Bela Lugosi", "123456789" );
		cliente.salvar();
		copia = new Cliente("Bela Lugosi", "123456789" );
	}
	
	@Test
	public void test00Consultar() {
		Cliente cli = new Cliente("test","123");
		cli.salvar();
		Cliente c = new Cliente();
		c.setId(  cli.getId() );
		c.consultar();
		
		assertEquals("teste consultar", c , cli );
		cli.excluir();
	}
	
	
	@Test
	public void test01Salvar() {
		cliente.consultar();
		copia.setId( cliente.getId() );
		copia.consultar();
		
		assertEquals("teste inclusao", copia , cliente );
	}

	@Test
	public void test02Atualizar() {
		cliente.setFone("123");
		
		copia.setId(  cliente.getId() );
		copia.setFone("123");
		
		
		cliente.atualizar();
		cliente.consultar();
		
		copia.consultar();
		
		assertEquals("teste atualizar", copia, cliente);
	}

	@Test
	public void tes03tExcluir() {
		Cliente c = new Cliente(null,null);
		c.setId(  cliente.getId() );
		cliente.excluir();
		cliente.consultar();
		c.consultar();
		assertEquals("teste inclusao", c , cliente );
	}



}
