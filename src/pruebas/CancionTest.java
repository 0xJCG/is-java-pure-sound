package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import puresound.Cancion;
import puresound.Genero;
import puresound.Puntuacion;

public class CancionTest {
 
	Puntuacion p1;
	Cancion c1;
	@Before
	public void setUp() throws Exception 
	{
		p1= new Puntuacion(7,"Buena");
		c1= new Cancion("qwerty",p1,Genero.POP,"asdgdfh");
	}
	@After
	public void tearDown() throws Exception 
	{
		p1=null;
		c1=null;
	}
	@Test
	public void testCompareTo() 
	{
		assertEquals(c1.compareTo("qwerty"), 0);
	}
	@Test
	public void testCancion() 
	{
		assertEquals(c1.getGenero(),Genero.POP);
		assertEquals(c1.getLetra(),"asdgdfh");
		assertEquals(c1.getNombre(),"qwerty");
		assertEquals(c1.getPuntuacion(),p1);
		
	}
}
