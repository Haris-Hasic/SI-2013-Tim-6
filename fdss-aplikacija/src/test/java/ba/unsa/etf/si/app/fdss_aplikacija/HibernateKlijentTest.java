
package ba.unsa.etf.si.app.fdss_aplikacija;



import java.util.List;

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
			k = new Klijent("Ajdin Kahrovic", "Supermarket","270699217217", "Uzaludna", "Sarajevo", "+38761503098", "kahrovic@hotmail.com", "www.etf.ba");
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
		Assert.assertTrue(hk.postojiKlijent("270699217217"));
	}

	@Test
	public void testBrisiKlijenta2() 
	{
		hk.dodajKlijenta(k);
		hk.brisiKlijenta(k);
		Assert.assertTrue(hk.postojiKlijent("270699217217"));
	}
	
	@Test
	public void testUpdateKlijenta() 
	{
		hk.dodajKlijenta(k);
		k.setMjesto("Sarajevo");
		hk.updateKlijenta(k);
		Klijent novi = hk.dajKlijenta("270699217217");
		Assert.assertEquals("Sarajevo", novi.getMjesto());
	}	
	
	
	@Test
	public void testVratiSveKlijente() 
	{
		hk.dodajKlijenta(k);
		List<Klijent> klijenti = hk.vratiSveKlijente();
		Assert.assertNotEquals(0, klijenti.size());
	}	
	
	@Test
	public void testVratiSveKlijente2() 
	{
		List<Klijent> klijenti;
		hk.dodajKlijenta(k);

		klijenti = hk.vratiSveKlijente();

		Assert.assertFalse(klijenti.contains(k));
	}	
	
}
