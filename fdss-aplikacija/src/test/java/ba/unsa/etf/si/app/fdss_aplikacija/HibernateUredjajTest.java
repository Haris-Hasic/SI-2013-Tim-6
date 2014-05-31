package ba.unsa.etf.si.app.fdss_aplikacija;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class HibernateUredjajTest {


	private HibernateUredjaj hu;
	private Uredjaj u;
	
	@Before 
	public void TestnePostavke () {
		u = new Uredjaj();
		u.setId(7777777);
		hu = new HibernateUredjaj();
	}
	
	@Test
	public void testDodajUredjaj() 
	{
		hu.dodajUredjaj(u);
		Assert.assertTrue(hu.postojiUredjaj(7777777));
	}
	
	@Test (expected = GeneralniException.class) 
	public void testBrisiUredjaj() 
	{
		hu.brisiUredjaj(u);
	}
	@Test
	public void testBrisiUredaj2() 
	{
		hu.dodajUredjaj(u);
		hu.brisiUredjaj(u);
		Assert.assertFalse(hu.postojiUredjaj(7777777));
	}
	
	@Test
	public void testUpdateUredjaj() 
	{
		hu.dodajUredjaj(u);
		u.setTipUredaja("uredjaj");
		hu.updateUredjaj(u);
		Uredjaj novi = hu.dajUredjaj(7777777);
		Assert.assertEquals("uredjaj", novi.getTipUredaja());
	}	
	
	@Test (expected = GeneralniException.class) 
	public void testUpdateUredjaj2() 
	{
		u.setTipUredaja("uredjaj");
		hu.updateUredjaj(u);
	}
	
	@Test
	public void testVratiSveUredjaje() 
	{
		hu.dodajUredjaj(u);
		List<Uredjaj> uredjaji = hu.vratiSveUredjaje();
		Assert.assertTrue(uredjaji.contains(u));
	}	
	
	@Test
	public void testVratiSveUredjaje2() 
	{
		List<Uredjaj> uredjaji;
		hu.dodajUredjaj(u);

		uredjaji = hu.vratiSveUredjaje();

		Assert.assertFalse(uredjaji.contains(u));
	}	
	

}
