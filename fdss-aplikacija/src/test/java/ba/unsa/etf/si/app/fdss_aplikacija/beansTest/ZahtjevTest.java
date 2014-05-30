package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;

import org.junit.*;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class ZahtjevTest {
	HibernateZahtjev hza;
	Zahtjev za;
	
	@Before
	public void TestnePostavke () {
		try {
			za =  new Zahtjev();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date rok = formatter.parse("14/09/2014");
			Date sadasnji = formatter.parse("31/05/2014");
			
			za.setRok(rok);
			za.setZahtjevPodnesen(sadasnji);
			za.setHitno(2);
			za.setId(123);
			za.setZavrsen(false);
			
			Uredjaj ur =  new Uredjaj();
			ur.setIbfu("EO021760");
			ur.setIbfm("EO021760");
			ur.setId(123);
			ur.setTipUredaja("kasa");
			ur.setJibProizvodaca("2706992172174");
			
			za.setUredjaj(ur);
			
			hza = new HibernateZahtjev();
		}
		
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		catch (Exception e) {
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		
	}
	
	@Test
	public void testDodavanjeZahtjeva() {
			long id = za.getId();
			hza.dodajZahtjev(za);
			
			Assert.assertTrue(hza.postojiZahtjev(id));
	}
	
	@Test
	public void testDodavanjeZahtjevaNeispravno() {
		Zahtjev z = new Zahtjev();
		SimpleDateFormat formatter;
		Date rok = null;
		try {
			
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			rok = formatter.parse("14/09/2014");
			Date sadasnji = formatter.parse("31/05/2014");
			
			z.setRok(rok);
			z.setZahtjevPodnesen(sadasnji);
			z.setHitno(2);
			z.setId(123);
			z.setZavrsen(false);
			z.setRok(formatter.parse("14/04/2014"));
			
			Assert.fail("Greska u datumima - rok je poslije datuma kreiranja zahtjeva.");
		}
		catch (Exception e) 
		{
				Assert.assertEquals(rok, z.getRok());
		
		}
		
		
		
	}
	
	
	@Test
	public void testUpdateZahtjeva() {

			long id = za.getId();
			hza.dodajZahtjev(za);
			
			za.setHitno(0);
			hza.updateZahtjev(za);
			Zahtjev novi = hza.dajZahtjev(id);
			
			Assert.assertEquals(0, novi.getHitno());
	}
	
	@Test
	public void testBrisanjeZahtjeva() {
			long id = za.getId();
			hza.dodajZahtjev(za);
			hza.brisiZahtjev(za);
			
			Assert.assertFalse(hza.postojiZahtjev(id));
	}
	
	@Test
	public void testPretragaZahtjeva() {
			long id = za.getId();
			hza.dodajZahtjev(za);
			
			Zahtjev za2 = hza.dajZahtjev(id);
			
			Assert.assertEquals(za, za2);
	}

}
