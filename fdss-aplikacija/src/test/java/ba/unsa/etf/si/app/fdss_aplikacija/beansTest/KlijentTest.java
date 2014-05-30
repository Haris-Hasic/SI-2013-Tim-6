package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;


import junit.framework.TestCase;


import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;

public class KlijentTest extends TestCase {

public void testGetSetJmbgIspravno() {
		
		try {
	
			Klijent k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
			k.setJib("1607991186528");
			
			assertEquals("1607991186528", k.getJib());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut Jib.");
		}
	}

}
