package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import puresound.ConciertoPasado;
import puresound.Discografica;
import puresound.Grupo;
import puresound.Puntuacion;

public class ConciertoPasadoTest {
	Discografica d1;
	Grupo g1;
	ConciertoPasado cp1;
	Calendar fecha;
	Puntuacion p1;
	
	@Before
	public void setUp() throws Exception 
	{
		p1= new Puntuacion(7,"Buena");
		fecha=Calendar.getInstance();
		fecha.set(1993, 12, 10);
		d1= new Discografica("QR", 2000);
		g1= new Grupo("RT",fecha,d1);
		cp1= new ConciertoPasado("QW",fecha,"Aqui",g1,"afasdg",245);
		
	}

	@After
	public void tearDown() throws Exception {
		fecha= null;
		d1= null;
		g1= null;
		cp1= null;
		p1=null;
	}
	@Test
	public void testAsistenciaYResumen()
	{
		assertEquals(cp1.verAsistenciaFinal(),245);
		assertEquals(cp1.verResumen(),"afasdg");
	}
	@Test
	public void testAddPuntuacion(){
		assertNull(cp1.getPuntuacion());
		cp1.addPuntuacion(p1);
		assertEquals(cp1.getPuntuacion(),p1);
	}
	@Test
	public void testRemovePuntuacion(){
		cp1.addPuntuacion(p1);
		assertEquals(cp1.getPuntuacion(),p1);
		cp1.removePuntuacion();
		assertNull(cp1.getPuntuacion());
	}
	@Test
	public void testCompareTo() {
		ConciertoPasado cp2 = new ConciertoPasado("QW",fecha,"Aqui",g1,"afasdg",245);
		assertEquals(cp1.compareTo(cp2),0);
	}
}
