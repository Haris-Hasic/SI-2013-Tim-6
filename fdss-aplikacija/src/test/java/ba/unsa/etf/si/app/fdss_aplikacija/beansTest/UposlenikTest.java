package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import org.junit.*;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;

public class UposlenikTest {

	@Test
	public void testGetSetJmbgIspravno() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJmbg("1703965714205");
			
			Assert.assertEquals("1703965714205", u.getJmbg());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		}
	}

	@Test
	public void testGetSetJmbgNeispravno() {
		
		Uposlenik u = new Uposlenik();
		
		try {
			
			u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			u.setJmbg("1111");
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
		} 
		
		catch (GeneralniException e) {
			
			Assert.assertEquals("1504992173043", u.getJmbg());
		}
	}

	@Test
	public void testGetSetTelefon() {
		
		try {
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
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
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
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
			
			Uposlenik u = new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
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
			
			Boolean flag=false;
			if (u.getAdresa()=="Trg djece Dobrinje" && u.getMjesto()=="Sarajevo" && u.getIme()=="Ajdin" && u.getPrezime()=="Kahrovic" && u.getJmbg()=="2706992172174" && u.getEmail()=="kahrovic@hotmail.com" && u.getPassword()=="sifra123" && u.getTelefon()=="+38761503098" && u.getUserName()=="akahrovic1" && u.getTip()==2)
				flag=true;
			
			Assert.assertTrue(flag);
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne radi update-ovanje uposlenika.");
		}
	}
}
