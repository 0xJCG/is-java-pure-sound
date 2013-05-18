package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Discografica;
import puresound.Grupo;
import puresound.ListaArtistas;
import puresound.Musico;
import puresound.Rol;
import puresound.Solista;

public class ListaArtistasTest {
	Grupo g1;
	Solista s1;
	Calendar fecha;
	Discografica d1;
	Musico m1;
	ListaArtistas la1;

	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		fecha.set(2000, 12, 3);
		m1 = new Musico("Musico", fecha, "Francia", Rol.BAJO);
		d1= new Discografica("Discografica", 1993);
		g1= new Grupo("Grupo", fecha,d1);
		s1= new Solista("Solista", fecha, m1, d1);
		la1= new ListaArtistas();
		
		la1.addArtista(g1);
		la1.addArtista(s1);
	}

	@After
	public void tearDown() throws Exception {
		fecha=null;
		m1=null;
		d1=null;
		g1=null;
		s1=null;
		la1=null;
	}

	@Test
	/*public void testaddArtista() {
		assertEquals(la1.getLista().size(),2); // getLista() es privado.
	}
	@Test
	public void testRemoveArtista(){
		la1.removeArtista(g1.getNombre());
		assertEquals(la1.getLista().size(),1);
	}*/
	public void testBuscarArtista(){
		assertEquals(la1.buscarArtista(s1.getNombre()),s1);
	}
}