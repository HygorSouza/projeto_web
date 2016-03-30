package remap.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import remap.model.Usuario;

public class UsuarioTest {
	Usuario user , copia ;
	
	@Before
	public void setUp() throws Exception {
		user = new Usuario("nome","cargo","senha");
		copia = new Usuario("nome","cargo","senha");
	}

	@Test
	public void testSalvar() {
		user.salvar();
		Usuario s = new Usuario();
		s.setId( user.getId() );
		s.consultar();
		
		assertEquals("testa inclusao", user , s );
	}

	

	@Test
	public void testAtualizar() {
		
		Usuario s = new Usuario();
		s.setId(  user.getId() );
		
		user.setUsuario("test");
		user.atualizar();
		
		s.consultar();
		
		assertEquals("testa inclusao", user , copia );
	}

	@Test
	public void testConsultar() {
		Usuario s = new Usuario();
		s.setId( user.getId() );
		
		user.consultar();
		s.consultar();
		
		
		assertEquals("testa consulta", user , s );
	}
	
	@Test
	public void testExcluir() {
		Usuario s = new Usuario();
		s.setId( user.getId() );
		
		user.excluir();
		user.consultar();
		s.consultar();
		
		assertEquals("testa exclusao", user , s );
		
		
	}

}
