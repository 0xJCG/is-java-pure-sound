package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Cancion;
import puresound.Genero;
import puresound.ListaCanciones;
import puresound.ListaCancionesFavoritas;
import puresound.Puntuacion;

public class ListaCancionesTest {
	Puntuacion p1;
	Cancion c1;
	Cancion c2;
	ListaCanciones lc1;

	@Before
	public void setUp() throws Exception {
		p1 = new Puntuacion(8, "Notable");
		c1 = new Cancion("Cancion 1", p1, Genero.CLASICA, "adghaps");
		c2 = new Cancion("Cancion 2", p1, Genero.CLASICA, "asdfgsd");
		lc1 = new ListaCanciones();
		
		lc1.addCancion(c1);
		lc1.addCancion(c2);
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		c1=null;
		c2=null;
		lc1=null;
	}

	@Test
	public void testAddCancion(){
		assertEquals(lc1.getLista().size(),2);
	}
	@Test
	public void testRemoveCancion(){
		lc1.removeCancion(c1.getNombre());
		assertEquals(lc1.getLista().size(),1);
	}
	@Test
	public void testBuscarCancion(){
		assertEquals(lc1.buscarCancion(c2.getNombre()),c2);
	}

}
