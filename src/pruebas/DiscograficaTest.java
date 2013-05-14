package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import puresound.Discografica;

public class DiscograficaTest {
	Discografica d1;
	@Before
	public void setUp() throws Exception {
		d1= new Discografica("QR", 2000);
	}

	@After
	public void tearDown() throws Exception {
		d1=null;
	}
	@Test
	public void testCompareTo() 
	{
		assertEquals(d1.compareTo("QR"), 0);	
	}

}
