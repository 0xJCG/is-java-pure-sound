package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Discografica;
import puresound.Grupo;
import puresound.ListaArtistasFavoritos;
import puresound.Musico;
import puresound.Rol;
import puresound.Solista;

public class ListaArtistasFavoritosTest {
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
		
		ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(g1);
		ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(s1);
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
	public void testAddArtista() {
		assertEquals(ListaArtistasFavoritos.getListaArtistasFavoritos().getLista().size(),2); //getLista() es privada.
	}
	@Test
	public void testRemoveArtista(){
		ListaArtistasFavoritos.getListaArtistasFavoritos().removeArtista(g1.getNombre());
		assertEquals(ListaArtistasFavoritos.getListaArtistasFavoritos().getLista().size(),1); //getLista() es privada.
	}*/
	@Test
	public void testBuscarArtista(){
		assertEquals(ListaArtistasFavoritos.getListaArtistasFavoritos().buscarArtista(s1.getNombre()),s1);
	}
}
