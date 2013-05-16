package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Discografica;
import puresound.Grupo;
import puresound.ListaArtistasTotal;
import puresound.Musico;
import puresound.Rol;
import puresound.Solista;

public class ListaArtistasTotalTest {
	Grupo g1;
	Solista s1;
	Calendar fecha;
	Discografica d1;
	Musico m1;

	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		fecha.set(2000, 12, 3);
		m1 = new Musico("Musico", fecha, "Francia", Rol.BAJO);
		d1= new Discografica("Discografica", 1993);
		g1= new Grupo("Grupo", fecha,d1);
		s1= new Solista("Solista", fecha, m1, d1);
		
		ListaArtistasTotal.getListaArtistasTotal().addArtista(g1);
		ListaArtistasTotal.getListaArtistasTotal().addArtista(s1);
	}

	@After
	public void tearDown() throws Exception {
		fecha=null;
		m1=null;
		d1=null;
		g1=null;
		s1=null;
	}

	/*@Test
	public void testaddArtista() {
		assertEquals(ListaArtistasTotal.getListaArtistasTotal().getLista().size(),2); //getLista() es privada
	}
	@Test
	public void testRemoveArtista(){
		ListaArtistasTotal.getListaArtistasTotal().removeArtista(g1.getNombre());
		assertEquals(ListaArtistasTotal.getListaArtistasTotal().getLista().size(),1); //getLista() es privada
	}*/
	
	@Test
	public void testBuscarArtista(){
		assertEquals(ListaArtistasTotal.getListaArtistasTotal().buscarArtista(s1.getNombre()),s1);
	}
}