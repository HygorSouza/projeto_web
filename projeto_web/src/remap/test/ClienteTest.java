package remap.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import remap.model.ClienteService;


public class ClienteTest {
	static ClienteService cliente , copia;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cliente = new ClienteService("Bela Lugosi", "123456789" );
		cliente.salvar();
		copia = new ClienteService("Bela Lugosi", "123456789" );
	}
	
	@Test
	public void test00Consultar() {
		ClienteService cli = new ClienteService("test","123");
		cli.salvar();
		ClienteService c = new ClienteService();
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
		ClienteService c = new ClienteService(null,null);
		c.setId(  cliente.getId() );
		cliente.excluir();
		cliente.consultar();
		c.consultar();
		assertEquals("teste inclusao", c , cliente );
	}



}
