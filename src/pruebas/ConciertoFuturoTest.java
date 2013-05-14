package pruebas;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.ConciertoFuturo;
import puresound.Discografica;
import puresound.Grupo;

public class ConciertoFuturoTest {
	Discografica d1;
	Grupo g1;
	ConciertoFuturo f1;
	Calendar fecha;
	@Before
	public void setUp() throws Exception 
	{
		fecha= Calendar.getInstance();
		fecha.set(2000, 12, 10);
		d1= new Discografica("QR", 2000);
		g1= new Grupo("RT",fecha,d1);
		f1= new ConciertoFuturo("QW",fecha,"Aqui",g1,245,"afasdg");
	}
	@After
	public void tearDown() throws Exception {
		fecha= null;
		d1= null;
		g1= null;
		f1= null;
	}
	@Test
	public void testAforoYAnuncio()
	{
		assertEquals(f1.verAforo(),245);
		assertEquals(f1.verAnuncio(),"afasdg");
	}
}