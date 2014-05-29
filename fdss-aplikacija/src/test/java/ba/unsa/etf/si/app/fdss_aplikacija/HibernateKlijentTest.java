package ba.unsa.etf.si.app.fdss_aplikacija;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;

import org.junit.*;

public class HibernateKlijentTest {

	private HibernateKlijent hk;
	private Klijent k;
	
	@Before 
	public void TestnePostavke () {
		try {
			k = new Klijent("Ajdin Kahrovic", "2706992172174", "Uzaludna", "Sarajevo", "+38761503098", "kahrovic@hotmail.com", "www.etf.ba");
		}
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		
		hk = new HibernateKlijent();
	}
	
	@Test
	public void testDodajKlijenta() 
	{
		hk.dodajKlijenta(k);
		Assert.assertTrue(hk.postojiKlijent("2706992172174"));
	}
	
	@Test (expected = Exception.class) 
	public void testBrisiKlijenta() 
	{
		hk.brisiKlijenta(k);
	}
	
	@Test
	public void testBrisiKlijenta2() 
	{
		hk.dodajKlijenta(k);
		hk.brisiKlijenta(k);
		Assert.assertFalse(hk.postojiKlijent("2706992172174"));
	}
	
	@Test
	public void testUpdateKlijenta() 
	{
		hk.dodajKlijenta(k);
		k.setMjesto("Zenica");
		hk.updateKlijenta(k);
		Klijent novi = hk.dajKlijenta("2706992172174");
		Assert.assertEquals("Zenica", novi.getMjesto());
	}	
	
	@Test (expected = Exception.class) 
	public void testUpdateKlijenta2() 
	{
		k.setMjesto("Zenica");
		hk.updateKlijenta(k);
	}
	
	
}
