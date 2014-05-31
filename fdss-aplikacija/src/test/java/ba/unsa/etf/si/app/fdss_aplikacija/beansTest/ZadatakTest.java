package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;

import org.junit.*;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class ZadatakTest {
	HibernateZadatak hza;
	Zadatak za;
	
	@Before
	public void TestnePostavke () {
		
		try {
			za =  new Zadatak();
			
			//zahtjev
			Zahtjev zah = new Zahtjev();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date rok = formatter.parse("14/09/2014");
			Date sadasnji = formatter.parse("31/05/2014");
			
			zah.setRok(rok);
			zah.setZahtjevPodnesen(sadasnji);
			zah.setHitno(2);
			zah.setId(123);
			zah.setZavrsen(false);
			za.setZahtjev(zah);
			
			
			//Serviser
			Uposlenik up =  new Uposlenik("Haris", "Hasic", "1504992173043", "Tuzlanska bb", "Olovo", "+38762380249", "haristd@hotmail.com", 1, "hhasic2", "harishasic21");
			
			
			//Ostali podaci
			Date noviRok = formatter.parse("14/07/2014");
			
			za.setZahtjevPodnesen((java.sql.Date)sadasnji);
			za.setZavrsitiDo((java.sql.Date)rok);
			za.setDonijetiUredjajDo((java.sql.Date)noviRok);
			
			za.setId(123);
			za.setZavrsen(false);
			
			hza = new HibernateZadatak();
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
	/*
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
		
	}*/
	
	
	@Test
	public void testUpdateZahtjeva() {

			long id = za.getId();
			hza.dodajZadatak(za);
			
			za.getServiser().setPrezime("Kahrovic");
			hza.updateZadatak(za);
			Zadatak novi = hza.dajZadatak(id);
			
			Assert.assertEquals("Kahrovic", novi.getServiser().getPrezime());
	}
	
	@Test
	public void testBrisanjeZahtjeva() {
			long id = za.getId();
			hza.dodajZadatak(za);
			hza.brisiZadatak(za);
			
			Assert.assertFalse(hza.postojiZadatak(id));
	}
	
	@Test
	public void testPretragaZadatka() {
			long id = za.getId();
			hza.dodajZadatak(za);
			
			Zadatak za2 = hza.dajZadatak(id);
			
			Assert.assertEquals(za, za2);
	}

}
