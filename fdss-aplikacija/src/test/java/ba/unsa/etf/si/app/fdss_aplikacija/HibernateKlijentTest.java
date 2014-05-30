package ba.unsa.etf.si.app.fdss_aplikacija;



import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;
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
	
	@Test (expected = GeneralniException.class) 
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
	
	@Test (expected = GeneralniException.class) 
	public void testUpdateKlijenta2() 
	{
		k.setMjesto("Zenica");
		hk.updateKlijenta(k);
	}
	
	@Test
	public void testVratiSveKlijente() 
	{
		hk.dodajKlijenta(k);
		List<Klijent> klijenti = hk.vratiSveKlijente();
		Assert.assertTrue(klijenti.contains(k));
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
