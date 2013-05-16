package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Disco;
import puresound.Discografica;
import puresound.Formato;
import puresound.Grupo;
import puresound.Musico;
import puresound.Rol;

public class GrupoTest {

	Grupo g1;
	Calendar fecha;
	Discografica d1;
	Musico m1;
	Musico m2;
	Musico m3;
	Disco disc1;
	Disco disc2;
	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		fecha.set(2010, 2, 19);
		m1= new Musico("Musico1",fecha, "Espa�a", Rol.CANTANTE);
		m2= new Musico("Musico2",fecha, "China", Rol.GUITARRA);
		m3= new Musico("Musico3",fecha, "Italia", Rol.BAJO);
		d1 = new Discografica("Disc", 1990);
		g1= new Grupo("Grupo", fecha, d1);
		disc1= new Disco("Disco1", 2011, Formato.DESCARGABLE);
		disc2= new Disco("Disco2", 2012, Formato.DESCARGABLE);
		
		g1.addDisco(disc1);
		g1.addDisco(disc2);
		g1.addIntegrante(m1);
		g1.addIntegrante(m2);
	}

	@After
	public void tearDown() throws Exception {
		g1=null;
		fecha=null;
		d1=null;
		m1=null;
		m2=null;
	}

	@Test
	public void testAddDisco() {
		assertEquals(g1.getDiscografia().getLista().size(),2);
	}
	@Test
	public void testRemoveDisco(){
		g1.removeDisco(disc1.getNombre());
		assertEquals(g1.getDiscografia().getLista().size(),1);
	}
	@Test
	public void testBuscarDisco(){
		assertEquals(g1.buscarDisco(disc2.getNombre()), disc2);
	}
	@Test
	public void testcambiarEstado(){
		g1.cambiarEstado();
		assertFalse(g1.estaActivo());
	}
	@Test
	public void testCompareTo(){
		Grupo g2= new Grupo("Grupo", fecha, d1);
		assertEquals(g1.compareTo(g2),0);
	}
	@Test
	public void testAddIntegrante(){
		assertEquals(g1.getIntegrantes().getLista().size(),2);
	}
	@Test
	public void testRemoveIntegrante(){
		g1.removeIntegrante(m1.getNombre());
		assertEquals(g1.getIntegrantes().getLista().size(),1);
	}
	@Test
	public void testReemplazarIntegrante(){
		g1.reemplazarIntegrante(m2.getNombre(), m3);
		assertTrue(g1.getIntegrantes().getLista().contains(m3));
	}
}
