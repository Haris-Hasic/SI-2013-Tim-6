package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import junit.framework.TestCase;

public class UposlenikTest extends TestCase {

	public void testGetSetJmbgIspravno() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJmbg("1703965714205");
			
			assertEquals("1703965714205", u.getJmbg());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		}
	}

	public void testGetSetJmbgNeispravno() {
		
		Uposlenik u = new Uposlenik();
		
		try {
			
			u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJmbg("1111");
			
			fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		} 
		
		catch (GeneralniException e) {
			
			assertEquals("1504992173043", u.getJmbg());
		}
	}

	public void testGetSetTelefon() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setTelefon("+38762666666");
			
			assertEquals("+38762666666", u.getTelefon());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut telefon.");
		}
	}

	public void testGetSetEmail() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setEmail("hhasic2@etf.unsa.ba");
			
			assertEquals("hhasic2@etf.unsa.ba", u.getEmail());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut telefon.");
		}
	}
}
