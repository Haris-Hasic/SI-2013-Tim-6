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
			k =  new Klijent("Firma", "Market","160799118652", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
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
public void testGetSetWebIspravno() {
	
	try {


		k.setWeb("firma.com");
		
		Assert.assertEquals("firma.com", k.getWeb());
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne rade get i set metode za atribut Web .");
	}
}


@Test
public void testGetSetMjestoIspravno() {

	
		k.setMjesto("Sarajevo");
		
		Assert.assertEquals("Sarajevo", k.getMjesto());

}

@Test
public void testGetSetNazivIspravno() {

	
		k.setNaziv("Firmaa");
		
		Assert.assertEquals("Firmaa", k.getNaziv());

}

@Test
public void testGetSetNazivAdresa() {

	
		k.setAdresa("Radiceva 10");
		
		Assert.assertEquals("Radiceva 10", k.getAdresa());

}



@Test
public void testUpdateKlijenta() {
	
	Klijent k = new Klijent();
	
	try {
		
		k.setAdresa("Trg djece Dobrinje");
		k.setMjesto("Sarajevo");
		k.setNaziv("Firma");
		k.setJib("270699217217");
		k.setEmail("firma@hotmail.com");
		k.setTelefon("+38761503098");
		k.setWeb("firma.com");
	
		
		Boolean flag=false;
		if (k.getAdresa()=="Trg djece Dobrinje" && k.getMjesto()=="Sarajevo" && k.getNaziv()=="Firma"  && k.getJib()=="270699217217" && k.getEmail()=="firma@hotmail.com" && k.getTelefon()=="+38761503098")
			flag=true;
		
		Assert.assertTrue(flag);
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne radi update-ovanje klijenta.");
	}
}


@Test
public void testpostojiKlijent() {
	
	HibernateKlijent h  = new HibernateKlijent();
	h.dodajKlijenta(k);
	Assert.assertTrue(h.postojiKlijent("160799118652"));
	
}

@Test
public void testBrisanjeKlijenta() {
		long id = k.getId();
		hk.dodajKlijenta(k);
		hk.brisiKlijenta(k);
		
		Assert.assertFalse(hk.postojiKlijent(id));
}

@Test
public void testPretragaKlijenta() {
		hk.dodajKlijenta(k);
		Assert.assertEquals(hk.dajKlijenta("160799118652").getAdresa(), "Dervisa Susica 2");
}




}
