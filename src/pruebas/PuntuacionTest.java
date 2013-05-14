package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Puntuacion;

public class PuntuacionTest {

	Puntuacion p1;
	@Before
	public void setUp() throws Exception {
		p1= new Puntuacion(7,"Buena");
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
	}

	@Test
	public void testPuntuacion() 
	{
		assertEquals(p1.getComentario(),"Buena");
		assertEquals(p1.getNota(),7);
	}

}
