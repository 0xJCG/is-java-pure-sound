package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Discografica;
import puresound.FestivalFuturo;
import puresound.Grupo;
import puresound.ListaMusicos;
import puresound.Musico;
import puresound.Rol;
import puresound.Solista;

public class FestivalFuturoTest {
	FestivalFuturo ff1;
	Calendar fecha;
	Solista s1;
	Grupo g1;
	Musico m1;
	ListaMusicos lm1;
	Discografica d1;
	@Before
	public void setUp() throws Exception {
		
		fecha= Calendar.getInstance();
		fecha.set(1990, 3, 10);
		d1 = new Discografica("Disco", 2003);
		m1= new Musico("Musico", fecha, "Somalia", Rol.CANTANTE);
		lm1= new ListaMusicos();
		ff1 = new FestivalFuturo("Festival", fecha, "Alli", 1230, "Anuncio");
		s1 = new Solista("Solista", fecha, m1, d1);
		
		ff1.addArtista(g1);
		ff1.addArtista(s1);
	}

	@After
	public void tearDown() throws Exception {
		ff1=null;
		fecha=null;
	}

	@Test
	public void testCompareTo() {
		assertEquals(ff1.compareTo("Festival"),0);
	}
	/*@Test
	public void testAddArtista(){
		assertEquals(ff1.getListaArtistas().getLista().size(),2);
	}
	@Test
	public void testremoveArtista(){
		ff1.removeArtista(s1.getNombre());
		assertEquals(ff1.getListaArtistas().getLista().size(),1);
	}*/
	@Test
	public void testAforoyAnuncio(){
		assertEquals(ff1.verAforo(),1230);
		assertEquals(ff1.verAnuncio(),"Anuncio");
	}
}
