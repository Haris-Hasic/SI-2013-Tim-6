package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;

import org.junit.*;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class KlijentTest {
	
	HibernateKlijent hk;
	Klijent k;
	
	@Before
	public void TestnePostavke () {
		try {
			k =  new Klijent("Firma", "Market","160799118652", "Dervisa Susica 2", "Brcko", "+38761579652", "Jasmin@hotmail.com","www.nesto.ba");
			hk = new HibernateKlijent();
		}
		
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		
	}
	
	
@Test
public void testGetSetJib() {
		
		try {
	

			k.setJib("160799118652");
			
			Assert.assertEquals("160799118652", k.getJib());
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Ne rade get i set metode za atribut Jib.");
		}
	}

@Test
public void testPostojiKlijent() {
	
	hk.dodajKlijenta(k);
	Assert.assertTrue(hk.postojiKlijent("160799118652"));
	hk.brisiKlijenta(k);	
}

@Test
public void testDodavanjeIBrisanjeKlijenta() {
		hk.dodajKlijenta(k);
		Klijent klijent=hk.dajKlijenta(k.getJib());
		long id=klijent.getId();
		Assert.assertTrue(hk.postojiKlijent(id));	
		hk.brisiKlijenta(klijent);
		Assert.assertFalse(hk.postojiKlijent(id));
}

@Test
public void testUpdateKlijenta() {
	
	Klijent klijent = new Klijent();
	
	try {
		
		klijent.setAdresa("Trg djece Dobrinje");
		klijent.setMjesto("Sarajevo");
		klijent.setNaziv("Firma");
		klijent.setJib("270699217210");
		klijent.setEmail("firma@hotmail.com");
		klijent.setTelefon("+38761503098");
		klijent.setWeb("www.firma.com");
		hk.dodajKlijenta(klijent);
		
		Klijent tempKlijent_1=hk.dajKlijenta("270699217210");
		tempKlijent_1.setJib("222222222222");
		hk.updateKlijenta(tempKlijent_1);
		
		Klijent tempKlijent_2=hk.dajKlijenta("222222222222");
				
		Boolean flag=false;
		if(tempKlijent_1.getId()==tempKlijent_2.getId())
			flag=true;
		hk.brisiKlijenta(tempKlijent_2);
		Assert.assertTrue(flag);
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Poruka: "+e.getMessage());
	}
}

@Test
public void testGetSetJibFail()
{
	try{
		String nepravilanJIB="1234567890";
		k.setJib(nepravilanJIB);
		Assert.fail("Nije bacen izuzetak.");
	}catch(Exception e)
	{
		Assert.assertTrue(true);
	}
}

@Test
public void testNepravilanEmail()
{
	try{
		Klijent k=new Klijent();
		k.setEmail("jasmin@gmailcom");
		Assert.fail("Email:: Nije bacen izuzetak");
	}catch (Exception e)
	{
		Assert.assertTrue(true);
	}
}

@Test
public void testNepravilanWeb()
{
	try{
		Klijent k=new Klijent();
		k.setEmail("webFirme");
		Assert.fail("WEB:: Nije bacen izuzetak");
	}catch (Exception e)
	{
		Assert.assertTrue(true);
	}
}
@Test
public void testNepravilanTelefon()
{
	try{
		Klijent k=new Klijent();
		k.setTelefon("225 883");
		Assert.fail("Telefon:: Nije bacen izuzetak");
	}catch (Exception e)
	{
		Assert.assertTrue(true);
	}
}

}
