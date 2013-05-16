package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Cancion;
import puresound.Genero;
import puresound.ListaCancionesFavoritas;
import puresound.Puntuacion;

public class ListaCancionesFavoritasTest {
	Puntuacion p1;
	Cancion c1;
	Cancion c2;

	@Before
	public void setUp() throws Exception {
		p1 = new Puntuacion(8, "Notable");
		c1 = new Cancion("Cancion 1", p1, Genero.CLASICA, "adghaps");
		c2 = new Cancion("Cancion 2", p1, Genero.CLASICA, "asdfgsd");
		
		ListaCancionesFavoritas.getListaCancionesFavoritas().addCancion(c1);
		ListaCancionesFavoritas.getListaCancionesFavoritas().addCancion(c2);
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		c1=null;
		c2=null;
	}

	/*@Test
	public void testAddCancion(){
		assertEquals(ListaCancionesFavoritas.getListaCancionesFavoritas().getLista().size(),2); //getLista() es privada
	}
	@Test
	public void testRemoveCancion(){
		ListaCancionesFavoritas.getListaCancionesFavoritas().removeCancion(c1.getNombre());
		assertEquals(ListaCancionesFavoritas.getListaCancionesFavoritas().getLista().size(),1); //getLista() es privada
	}*/
	
	@Test
	public void testBuscarCancion(){
		assertEquals(ListaCancionesFavoritas.getListaCancionesFavoritas().buscarCancion(c2.getNombre()),c2);
	}
}
