package remap.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import remap.model.UsuarioService;


public class UsuarioTest {
	static UsuarioService user ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new UsuarioService("nome","senha");
		user.salvar();
	}

	@Test
	public void testSalvar() {
		UsuarioService s = new UsuarioService();
		s.setId( user.getId() );
		s.consultar();
		
		assertEquals("teste inclusao", user , s );
	}

	

	@Test
	public void testAtualizar() {
		
		UsuarioService s = new UsuarioService();
		s.setId(  user.getId() );
		
		user.setUsuario("test");
		user.atualizar();
		
		s.consultar();
		
		assertEquals("teste atualizar", user , s );
	}

	@Test
	public void testConsultar() {
		UsuarioService s = new UsuarioService();
		s.setId( user.getId() );
		
		user.consultar();
		s.consultar();
		
		
		assertEquals("teste consulta", user , s );
	}
	
	@Test
	public void testExcluir() {
		UsuarioService s = new UsuarioService();
		s.setId( user.getId() );
		
		
		user.excluir();
		user.consultar();
		s.consultar();
		
		System.out.println( user.getId() );
		System.out.println( s.getId() );
		
		assertEquals("testa excluir", user , s );
		
		
	}

}
