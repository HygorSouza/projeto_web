package remap.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import remap.model.Usuario;


public class UsuarioTest {
	static Usuario user ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new Usuario("nome","cargo","senha");
		user.salvar();
	}

	@Test
	public void testSalvar() {
		Usuario s = new Usuario();
		s.setId( user.getId() );
		s.consultar();
		
		assertEquals("teste inclusao", user , s );
	}

	

	@Test
	public void testAtualizar() {
		
		Usuario s = new Usuario();
		s.setId(  user.getId() );
		
		user.setUsuario("test");
		user.atualizar();
		
		s.consultar();
		
		assertEquals("teste atualizar", user , s );
	}

	@Test
	public void testConsultar() {
		Usuario s = new Usuario();
		s.setId( user.getId() );
		
		user.consultar();
		s.consultar();
		
		
		assertEquals("teste consulta", user , s );
	}
	
	@Test
	public void testExcluir() {
		Usuario s = new Usuario();
		s.setId( user.getId() );
		
		
		user.excluir();
		user.consultar();
		s.consultar();
		
		System.out.println( user.getId() );
		System.out.println( s.getId() );
		
		assertEquals("testa excluir", user , s );
		
		
	}

}
