package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.ListaMusicos;
import puresound.Musico;
import puresound.Rol;

public class ListaMusicosTest {
	ListaMusicos lm1;
	Musico m1;
	Musico m2;
	Calendar fecha;

	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		m1= new Musico("Musico 1", fecha, "España", Rol.CANTANTE);
		m2= new Musico("Musico 2", fecha, "España", Rol.BATERIA);
		lm1= new ListaMusicos();
		
		lm1.addMusico(m1);
		lm1.addMusico(m2);
	}

	@After
	public void tearDown() throws Exception {
		fecha= null;
		m1= null;
		m2=null;
		lm1=null;
	}

	@Test
	public void testAddMusico() {
		assertEquals(lm1.getLista().size(),2);
	}
	@Test
	public void testRemoveMusico(){
		lm1.removeMusico(m1.getNombre());
		assertEquals(lm1.getLista().size(),1);
	}
	@Test
	public void testBuscarMusico(){
		assertEquals(lm1.buscarMusico(m2.getNombre()),m2);
	}

}
