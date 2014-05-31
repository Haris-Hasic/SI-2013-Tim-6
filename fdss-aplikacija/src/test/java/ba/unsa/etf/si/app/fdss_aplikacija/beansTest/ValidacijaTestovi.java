package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class ValidacijaTestovi {

	@Test
	public void ValidirajJmbg() {
		Validacija v = new Validacija();
		assertEquals(true,v.validirajJMBG("1607991186528"));
	}

	
	

}
