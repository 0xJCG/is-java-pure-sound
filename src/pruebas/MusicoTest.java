package pruebas;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Musico;
import puresound.Rol;

public class MusicoTest {

	Musico m1;
	Calendar fecha;
	@Before
	public void setUp() throws Exception {
		fecha= Calendar.getInstance();
		m1= new Musico("Musico", fecha, "Somalia", Rol.BAJO);
	}

	@After
	public void tearDown() throws Exception {
		fecha=null;
		m1=null;
	}

	@Test
	public void testCompareTo() {
		assertEquals(m1.compareTo("Musico"),0);
	}

}
