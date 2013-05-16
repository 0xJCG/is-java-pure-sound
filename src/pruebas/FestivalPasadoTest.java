package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Discografica;
import puresound.FestivalPasado;
import puresound.Grupo;
import puresound.ListaMusicos;
import puresound.Musico;
import puresound.Puntuacion;
import puresound.Rol;
import puresound.Solista;

public class FestivalPasadoTest {

	FestivalPasado fp1;
	Calendar fecha;
	Solista s1;
	Grupo g1;
	Musico m1;
	ListaMusicos lm1;
	Discografica d1;
	Puntuacion p1;
	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		fecha.set(1990, 3, 10);
		m1= new Musico("Musico", fecha, "Somalia", Rol.CANTANTE);
		lm1= new ListaMusicos();
		d1 = new Discografica("Disco", 2003);
		fp1 = new FestivalPasado("Festival", fecha, "Alli", "Resumen", 1230);
		s1 = new Solista("Solista", fecha, m1, d1);
		g1= new Grupo("Frupo", fecha, d1);
		p1= new Puntuacion(10, "Sobresaliente");
		
		fp1.addArtista(g1);
		fp1.addArtista(s1);
	}

	@After
	public void tearDown() throws Exception {
		fp1=null;
		fecha=null;
		m1=null;
		lm1=null;
		d1=null;
		s1=null;
		g1=null;
		
		fp1.addPuntuacion(p1);
	}

	@Test
	public void testCompareTo() {
		FestivalPasado fp2 = new FestivalPasado("Festival", fecha, "Alli", "Resumen", 1230);
		assertEquals(fp1.compareTo(fp2),0);
	}
	/*@Test
	public void testAddArtista() {
		assertEquals(fp1.getListaArtistas().getLista().size(),2);
	}
	@Test
	public void testRemoveArtista() {
		fp1.removeArtista(s1.getNombre());
		assertEquals(fp1.getListaArtistas().getLista().size(),1);
	}*/
	@Test
	public void testVerResumenYFinal() {
		assertEquals(fp1.verResumen(),"Resumen");
		assertEquals(fp1.verAsistenciaFinal(),1230);
	}
	@Test
	public void testAddPuntuacion() {
		assertEquals(fp1.getPuntuacion(),p1);
	}
	@Test
	public void testRemovePuntuacion() {
		fp1.removePuntuacion();
		assertNull(fp1.getPuntuacion());
	}
}
