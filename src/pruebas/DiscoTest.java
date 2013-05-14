package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Cancion;
import puresound.Disco;
import puresound.Formato;
import puresound.Genero;
import puresound.Puntuacion;

public class DiscoTest {

	Puntuacion p1;
	Cancion c1;
	Cancion c2;
	Disco d1;
	@Before
	public void setUp() throws Exception {
		p1= new Puntuacion(7,"Buena");
		c1= new Cancion("qwerty",p1,Genero.POP,"aasdgf");
		c2= new Cancion("awerty",p1,Genero.ROCK,"sdfghdfh");
		d1= new Disco("Disco", 2000, Formato.DESCARGABLE);
		
		d1.addCancion(c1);
		d1.addCancion(c2);
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		c1=null;
		c2=null;
		d1=null;
	}

	@Test
	public void testAddCancion(){
		assertEquals(d1.getCanciones().getLista().size(),2);
	}
	@Test
	public void testRemoveCancion(){
		d1.removeCancion(c1.getNombre());
		assertEquals(d1.getCanciones().getLista().size(),1);
	}
	@Test
	public void testBuscarCancion(){
		assertEquals(d1.buscarCancion(c2.getNombre()),c2);
		d1.removeCancion(c2.getNombre());
		assertNull(d1.buscarCancion(c2.getNombre()));
	}

}
