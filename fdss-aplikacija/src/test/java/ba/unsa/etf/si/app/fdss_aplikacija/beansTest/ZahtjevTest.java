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

}
