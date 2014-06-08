package ba.unsa.etf.si.app.fdss_aplikacija;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class ValidacijaTestovi {
	
	Validacija v = new Validacija();
	
	@Test
	public void ValidirajJmbg() {
	    
		boolean validan = Validacija.validirajEmail("email@hotmail.com");
		assertTrue(validan);
	}
	@Test
	public void ValidirajIbfm() {
		
		assertTrue(Validacija.validirajIBFM("12345678"));
	}
	@Test
	public void ValidirajIbfu() {
		
		assertEquals(true,Validacija.validirajIBFU("12345670"));
	}
	
	@Test
	public void ValidirajEmail() {
	
	assertEquals(true,Validacija.validirajEmail("eganilovic1@hotmail.com"));
}
	
	@Test
	public void ValidirajTelefon() {
	
	assertEquals(true,Validacija.validirajTelefon("+3876157965"));
}

}
