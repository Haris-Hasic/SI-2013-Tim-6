package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import junit.framework.TestCase;

public class UposlenikTest extends TestCase {

	public void testGetSetIme() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setIme("Bego");
			
			assertEquals("Bego", u.getIme());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut ime.");
		}
		
	}

	public void testGetSetPrezime() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setPrezime("xxx");
			
			assertEquals("xxx", u.getPrezime());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut prezime.");
		}
	}

	public void testGetSetJibIspravno() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJib("1703965714205");
			
			assertEquals("1703965714205", u.getJib());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		}
	}

	public void testGetSetJibNeispravno() {
		
		Uposlenik u = new Uposlenik();
		
		try {
			
			u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJib("1111");
			
			fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		} 
		
		catch (GeneralniException e) {
			
			assertEquals("1504992173043", u.getJib());
		}
	}

	public void testGetSetAdresa() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setAdresa("Sarajevska bb");
			
			assertEquals("Sarajevska bb", u.getAdresa());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut adresa.");
		}
	}

	public void testGeSettMjesto() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setMjesto("Sarajevo");
			
			assertEquals("Sarajevo", u.getMjesto());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut mjesto.");
		}
	}

	public void testGetSetTelefon() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setTelefon("+38762666666");
			
			assertEquals("+38762666666", u.getTelefon());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut telefon.");
		}
	}

	public void testGetSetEmail() {
		
		try {
			
			Uposlenik u = new Uposlenik(1, "Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setEmail("hhasic2@etf.unsa.ba");
			
			assertEquals("hhasic2@etf.unsa.ba", u.getEmail());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut telefon.");
		}
	}

	public void testGetSetUserName() {
		fail("Not yet implemented"); // TODO
	}

	public void testGetSetPassword() {
		fail("Not yet implemented"); // TODO
	}

}
