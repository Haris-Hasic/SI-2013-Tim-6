package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Hitnost;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class ZahtjevTest {

	Uredjaj ur;
	HibernateUredjaj hur;
	Zahtjev zahtjev;
	HibernateZahtjev hz;
	@Before
	public void TestnePostavke () {
		try {
			ur =  new Uredjaj();
			ur.setIbfu("EO021760");
			ur.setIbfm("EO021760");
			ur.setTipUredaja("kasa");
			ur.setJibProizvodaca("270699217217");
			hur = new HibernateUredjaj();
			hur.dodajUredjaj(ur);
			
			zahtjev=new Zahtjev();
			zahtjev.setHitnost(Hitnost.SREDNJA);
			zahtjev.setRok(new java.sql.Date(new Date().getTime()));
			zahtjev.setUredjaj(hur.dajUredjaj("EO021760"));
			
			zahtjev.setZahtjevPodnesen(new java.sql.Date(new Date().getTime()));
			zahtjev.setZavrsen(false);
			
			hz=new HibernateZahtjev();
		}
		
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
	}
	@Test
	public void testDodavanjeZahtjeva()
	{
		Uredjaj u=hur.dajUredjaj("EO021760");
		Zahtjev z=new Zahtjev();
		try
		{
			z.setUredjaj(u);
		}catch(Exception e)
		{
			
		}
		hz.dodajZahtjev(z);
		
		Zahtjev tmp=hz.dajSveZahtjeve().get(hz.dajSveZahtjeve().size()-1);
		Assert.assertTrue(hz.postojiZahtjev(tmp.getId()));
		hz.brisiZahtjev(tmp);
	}
	
	@Test
	public void testGetSetZavrsen()
	{
		zahtjev.setZavrsen(true);
		Assert.assertTrue(zahtjev.isZavrsen());
		
	}
	
	@Test
	public void testGetSetUredjaj()
	{
		try
		{
			Uredjaj ur;
			ur =  new Uredjaj();
			ur.setIbfu("EO023330");
			ur.setIbfm("EO023330");
			ur.setTipUredaja("kasa");
			ur.setJibProizvodaca("270699217217");
			
			zahtjev.setUredjaj(ur);
			Assert.assertEquals(zahtjev.getUredjaj(), ur);
			
		}catch(Exception e)
		{
			
		}
	}
	@Test
	public void testGetSetHitnost()
	{
		zahtjev.setHitnost(Hitnost.VELIKA);
		Assert.assertEquals(zahtjev.getHitnost(),Hitnost.VELIKA);
	}
	
	@After
	public void brisanje()
	{
		hur.brisiUredjaj(ur);
	}

}
