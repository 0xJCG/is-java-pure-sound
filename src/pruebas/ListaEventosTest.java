package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.ConciertoFuturo;
import puresound.ConciertoPasado;
import puresound.Discografica;
import puresound.ListaEventos;
import puresound.Musico;
import puresound.Rol;
import puresound.Solista;

public class ListaEventosTest {
	ConciertoPasado cp1;
	ConciertoFuturo cf1;
	Solista s1;
	Musico m1;
	Discografica d1;
	Calendar fecha;

	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		fecha.set(2009, 5, 1);
		d1= new Discografica("Discografica", 1990);
		m1= new Musico("Musico", fecha, "Inglaterra", Rol.CANTANTE);
		s1= new Solista("Solista", fecha, m1, d1);
		cp1= new ConciertoPasado("Pasado",fecha, "Lugar", s1, "Resumen", 2000);	
		cf1= new ConciertoFuturo("Futuro",fecha, "Alli", s1, 5000, "Anuncio");
		
		ListaEventos.getListaEventos().addEvento(cf1);
		ListaEventos.getListaEventos().addEvento(cp1);
		}

	@After
	public void tearDown() throws Exception {
		fecha=null;
		d1=null;
		m1=null;
		s1=null;
		cp1=null;
		cf1=null;
	}

	/*@Test
	public void testAddEvento() {
		assertEquals(ListaEventos.getListaEventos().getLista().size(),2); //getLista() es privada
	}
	@Test
	public void testRemoveEvento(){
		ListaEventos.getListaEventos().removeEvento(cf1.getNombre());
		assertEquals(ListaEventos.getListaEventos().getLista().size(),1); //getLista() es privada
	}*/
	
	@Test
	public void buscarEvento(){
		assertEquals(ListaEventos.getListaEventos().buscarEvento(cp1.getNombre()),cp1);
	}

}
