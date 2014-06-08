package ba.unsa.etf.si.app.fdss_aplikacija;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class UposlenikTest {
	
	HibernateUposlenik hu;
	Uposlenik u;
	
	@Before
	public void TestnePostavke () {
		
		try {
			
			hu = new HibernateUposlenik();
			u =  new Uposlenik("Kemo", "Administrator", "1703965714205", "Branilaca grada", "Mostar", "+38762123456", "kemica@hotmail.com", 1, "kemo", "moke6969");
		}
		
		catch (GeneralniException e)
		{
			Validacija v = new Validacija();
			v.poruka(e.getMessage());
		}
	}
	
	@Test
	public void testGetSetNazivAdresa() {

			try {

				u.setAdresa("Radiceva 10");
				Assert.assertEquals("Radiceva 10", u.getAdresa());
			} 
			
			catch (GeneralniException e) {
				
				Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
			}
	}

	@Test
	public void testGetSetJmbgIspravno() {
		
		try {

			u.setJmbg("1703965714205");
			Assert.assertEquals("1703965714205", u.getJmbg());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		}
	}

	@Test
	public void testGetSetJmbgNeispravno() {
		
		try {
			
			u.setJmbg("1111");
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		} 
		
		catch (GeneralniException e) {
			
			Assert.assertEquals("1703965714205", u.getJmbg());
		}
	}

	@Test
	public void testGetSetTelefon() {
		
		try {
			
			u.setTelefon("+38762666666");
			Assert.assertEquals("+38762666666", u.getTelefon());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut telefon.");
		}
	}

	@Test
	public void testGetSetEmail() {
		
		try {
			
			u.setEmail("hhasic2@etf.unsa.ba");
			Assert.assertEquals("hhasic2@etf.unsa.ba", u.getEmail());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut e-mail.");
		}
	}
	
	@Test
	public void testUpdateUposlenika() {
		
		try {
		
			hu.dodajUposlenika(u);
			
			u.setAdresa("Trg djece Dobrinje");
			u.setMjesto("Sarajevo");
			u.setIme("Ajdin");
			u.setPrezime("Kahrovic");
			u.setJmbg("2706992172174");
			u.setEmail("kahrovic@hotmail.com");
			u.setTelefon("+38761503098");
			u.setUserName("akahrovic");
			u.setPassword("sifra123");
			u.setTip(2);
			
			hu.updateUposlenika(u);
			Uposlenik novi = hu.dajUposlenika("akahrovic");
			Boolean b = hu.postojiUposlenikJMBG(u.getJmbg());
			hu.brisiUposlenika(u);
			
			Assert.assertTrue(b);
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne radi update-ovanje uposlenika.");
		}
	}
	
	@Test
	public void testBrisanjeUposlenika() {
		
			hu.dodajUposlenika(u);
			hu.brisiUposlenika(u);
			
			Assert.assertFalse(hu.postojiUposlenik(u.getJmbg()));
	}
	
	@Test
	public void testPretragaUposlenika() {
		
			hu.dodajUposlenika(u);
			int b = hu.dajUposlenikaJMBG("1703965714205").getMjesto().compareTo("Mostar");
			hu.brisiUposlenika(u);
			
			Assert.assertEquals(0, b);
	}
	
	@After
	public void TestniTeardown() {
		
		try {
			
			hu = new HibernateUposlenik();
			Uposlenik u1 =  new Uposlenik("Kemo", "Administrator", "1703965714205", "Branilaca grada", "Mostar", "+38762123456", "kemica@hotmail.com", 1, "kemo", "moke6969");
			Uposlenik u2 = new Uposlenik("Ajdin", "Kahrovic", "2706992172174", "Trg djece Dobrinje", "Sarajevo", "+38761503098", "kahrovic@hotmail.com", 2, "akahrovic", "sifra123");
			
			hu.brisiUposlenika(u1);
			hu.brisiUposlenika(u2);
		}
		
		catch (GeneralniException e)
		{
			Validacija v = new Validacija();
			v.poruka(e.getMessage());
		}
	}
}

