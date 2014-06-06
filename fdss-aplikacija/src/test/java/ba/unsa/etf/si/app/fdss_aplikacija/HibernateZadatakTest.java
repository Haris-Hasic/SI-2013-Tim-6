package ba.unsa.etf.si.app.fdss_aplikacija;

import static org.junit.Assert.*;

import java.sql.Date;

import junit.framework.Assert;

import org.junit.Test;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Hitnost;

public class HibernateZadatakTest {

	@Test
	public void testDodavanjeIBrisanjeZadatak() {
		try {
			
			Uredjaj u=new Uredjaj();
			u.setIbfu("FO021760");
			u.setIbfm("FO021760");
			u.setTipUredaja("printer");
			u.setJibProizvodaca("370699217217");
			
			Zahtjev zahtjev=new Zahtjev();
			zahtjev.setUredjaj(u);
			zahtjev.setZahtjevPodnesen(new Date(114,6,6));
			zahtjev.setRok(new Date(114,6,20));
			zahtjev.setZavrsen(false);
			zahtjev.setHitno(2);
						
			Uposlenik up =  new Uposlenik("Miki", "Maus", "1204955800069", "Diznilend", "Pariz", "+38763159753", "miki@hotmail.com", 3, "miki1", "mini");
			
			Zadatak z=new Zadatak();
			z.setDonijetiUredjajDo(new Date(114,6,8));
			z.setZahtjev(zahtjev);
			z.setServiser(up);
			z.setZavrsen(false);
			z.setZavrsitiDo(new Date(114,6,20));
			z.setHitnost("SREDNJA");
			z.setZahtjevPodnesen(new Date(114,6,6));
			
			HibernateUposlenik huposlenik=new HibernateUposlenik();
			huposlenik.dodajUposlenika(up);
			
			HibernateUredjaj huredjaj=new HibernateUredjaj();
			huredjaj.dodajUredjaj(u);
			
			HibernateZahtjev hzahtjev1=new HibernateZahtjev();
			hzahtjev1.dodajZahtjev(zahtjev);
			
			HibernateZadatak hzadatak1=new HibernateZadatak();
			hzadatak1.dodajZadatak(z);
			
			Assert.assertTrue(hzadatak1.postojiZadatak(z.getId()));
			
			hzadatak1.brisiZadatak(z);
			hzahtjev1.brisiZahtjev(zahtjev);
			huredjaj.brisiUredjaj(u);
			huposlenik.brisiUposlenika(up);
			
			Assert.assertFalse(hzadatak1.postojiZadatak(z.getId()));
		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateZadatak() {
		try {
			Uredjaj u=new Uredjaj();
			u.setIbfu("FO021760");
			u.setIbfm("FO021760");
			u.setTipUredaja("printer");
			u.setJibProizvodaca("370699217217");
			
			Zahtjev zahtjev=new Zahtjev();
			zahtjev.setUredjaj(u);
			zahtjev.setZahtjevPodnesen(new Date(114,6,6));
			zahtjev.setRok(new Date(114,6,20));
			zahtjev.setZavrsen(false);
			zahtjev.setHitno(2);
						
			Uposlenik up =  new Uposlenik("Miki", "Maus", "1204955800069", "Diznilend", "Pariz", "+38763159753", "miki@hotmail.com", 3, "miki1", "mini");
			
			Zadatak z=new Zadatak();
			z.setDonijetiUredjajDo(new Date(114,6,8));
			z.setZahtjev(zahtjev);
			z.setServiser(up);
			z.setZavrsen(false);
			z.setZavrsitiDo(new Date(114,6,20));
			z.setHitnost("SREDNJA");
			z.setZahtjevPodnesen(new Date(114,6,6));
			
			HibernateUposlenik huposlenik=new HibernateUposlenik();
			huposlenik.dodajUposlenika(up);
			
			HibernateUredjaj huredjaj=new HibernateUredjaj();
			huredjaj.dodajUredjaj(u);
			
			HibernateZahtjev hzahtjev1=new HibernateZahtjev();
			hzahtjev1.dodajZahtjev(zahtjev);
			
			HibernateZadatak hzadatak1=new HibernateZadatak();
			hzadatak1.dodajZadatak(z);
			
			//ukoliko je u bazi vec dodavano zadataka postavljamo broj zadataka na samo nas kako bismo mogli provjeriti velicinu niza nezavrsenih zadataka
			int ukupno=0;
			if (hzadatak1.dajSveNezavrseneZadatke().size()>1)ukupno=hzadatak1.dajSveNezavrseneZadatke().size()-1;
			z.setDonijetiUredjajDo(new Date(114,6,7));
			z.setZavrsitiDo(new Date(114,6,13));
			z.setHitnost("HITNO");
			z.setZavrsen(true);
			hzadatak1.updateZadatak(z);
			Assert.assertEquals(z, hzadatak1.dajZadatak(z.getId()));
			Assert.assertTrue(hzadatak1.dajSveNezavrseneZadatke().size()-ukupno==0);
			
			hzadatak1.brisiZadatak(z);
			hzahtjev1.brisiZahtjev(zahtjev);
			huredjaj.brisiUredjaj(u);
			huposlenik.brisiUposlenika(up);
			
			Assert.assertFalse(hzadatak1.postojiZadatak(z.getId()));
		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDajSveNezavrseneZadatke() {
		try {
			Uredjaj u=new Uredjaj();
			u.setIbfu("FO021760");
			u.setIbfm("FO021760");
			u.setTipUredaja("printer");
			u.setJibProizvodaca("370699217217");
			
			Zahtjev zahtjev=new Zahtjev();
			zahtjev.setUredjaj(u);
			zahtjev.setZahtjevPodnesen(new Date(114,6,6));
			zahtjev.setRok(new Date(114,6,20));
			zahtjev.setZavrsen(false);
			zahtjev.setHitno(2);
						
			Uposlenik up =  new Uposlenik("Miki", "Maus", "1204955800069", "Diznilend", "Pariz", "+38763159753", "miki@hotmail.com", 3, "miki1", "mini");
			Uposlenik up2 =  new Uposlenik("Tom", "Macka", "2009974788955", "Negdje", "Sarajevo", "+38761259753", "tom@gmail.com", 3, "tom1", "dzeri");
			
			//dodijeljen prvom uposleniku
			Zadatak z=new Zadatak();
			z.setDonijetiUredjajDo(new Date(114,6,8));
			z.setZahtjev(zahtjev);
			z.setServiser(up);
			z.setZavrsen(false);
			z.setZavrsitiDo(new Date(114,6,20));
			z.setHitnost("SREDNJA");
			z.setZahtjevPodnesen(new Date(114,6,6));
			
			//dodijeljen prvom uposleniku
			Zadatak z2=new Zadatak();
			z2.setDonijetiUredjajDo(new Date(114,6,8));
			z2.setZahtjev(zahtjev);
			z2.setServiser(up);
			z2.setZavrsen(false);
			z2.setZavrsitiDo(new Date(114,6,20));
			z2.setHitnost("SREDNJA");
			z2.setZahtjevPodnesen(new Date(114,6,6));
			
			//dodijeljen drugom uposleniku
			Zadatak z3=new Zadatak();
			z3.setDonijetiUredjajDo(new Date(114,6,8));
			z3.setZahtjev(zahtjev);
			z3.setServiser(up2);
			z3.setZavrsen(false);
			z3.setZavrsitiDo(new Date(114,6,20));
			z3.setHitnost("SREDNJA");
			z3.setZahtjevPodnesen(new Date(114,6,6));
			
			//dodavanja u bazu
			HibernateUposlenik huposlenik=new HibernateUposlenik();
			huposlenik.dodajUposlenika(up);
			huposlenik.dodajUposlenika(up2);
			
			HibernateUredjaj huredjaj=new HibernateUredjaj();
			huredjaj.dodajUredjaj(u);
			
			HibernateZahtjev hzahtjev1=new HibernateZahtjev();
			hzahtjev1.dodajZahtjev(zahtjev);
			
			HibernateZadatak hzadatak1=new HibernateZadatak();
			hzadatak1.dodajZadatak(z);
			hzadatak1.dodajZadatak(z2);
			hzadatak1.dodajZadatak(z3);
			
			//ukoliko je u bazi vec dodavano zadataka postavljamo broj zadataka na samo nasa tri kako bismo mogli provjeriti velicinu niza nezavrsenih zadataka
			int ukupno=0;
			if (hzadatak1.dajSveNezavrseneZadatke().size()>3)ukupno=hzadatak1.dajSveNezavrseneZadatke().size()-3;
			//testiranje ispravnosti vracanja svih nezavrsenih zadataka
			Assert.assertTrue(hzadatak1.dajSveNezavrseneZadatke().size()-ukupno==3);
			z2.setZavrsen(true);
			hzadatak1.updateZadatak(z2);
			Assert.assertTrue(hzadatak1.dajSveNezavrseneZadatke().size()-ukupno==2);
			
			//testiranje ispravnosti vracanja nezavrsenih zadataka prema uposlenicima
			Assert.assertTrue(hzadatak1.dajSveNezavrseneZadatke(up).size()==1);
			Assert.assertTrue(hzadatak1.dajSveNezavrseneZadatke(up2).size()==1);
			z3.setZavrsen(true);
			hzadatak1.updateZadatak(z3);
			Assert.assertTrue(hzadatak1.dajSveNezavrseneZadatke(up2).size()==0);
			
			//ciscenje baze
			hzadatak1.brisiZadatak(z);
			hzadatak1.brisiZadatak(z2);
			hzadatak1.brisiZadatak(z3);
			hzahtjev1.brisiZahtjev(zahtjev);
			huredjaj.brisiUredjaj(u);
			huposlenik.brisiUposlenika(up);
			huposlenik.brisiUposlenika(up2);

		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDajSveZadatke() {
		try {
			Uredjaj u=new Uredjaj();
			u.setIbfu("FO021760");
			u.setIbfm("FO021760");
			u.setTipUredaja("printer");
			u.setJibProizvodaca("370699217217");
			
			Zahtjev zahtjev=new Zahtjev();
			zahtjev.setUredjaj(u);
			zahtjev.setZahtjevPodnesen(new Date(114,6,6));
			zahtjev.setRok(new Date(114,6,20));
			zahtjev.setZavrsen(false);
			zahtjev.setHitno(2);
						
			Uposlenik up =  new Uposlenik("Miki", "Maus", "1204955800069", "Diznilend", "Pariz", "+38763159753", "miki@hotmail.com", 3, "miki1", "mini");
			Uposlenik up2 =  new Uposlenik("Tom", "Macka", "2009974788955", "Negdje", "Sarajevo", "+38761259753", "tom@gmail.com", 3, "tom1", "dzeri");
			
			//dodijeljen prvom uposleniku
			Zadatak z=new Zadatak();
			z.setDonijetiUredjajDo(new Date(114,6,8));
			z.setZahtjev(zahtjev);
			z.setServiser(up);
			z.setZavrsen(false);
			z.setZavrsitiDo(new Date(114,6,20));
			z.setHitnost("SREDNJA");
			z.setZahtjevPodnesen(new Date(114,6,6));
			
			//dodijeljen prvom uposleniku
			Zadatak z2=new Zadatak();
			z2.setDonijetiUredjajDo(new Date(114,6,8));
			z2.setZahtjev(zahtjev);
			z2.setServiser(up);
			z2.setZavrsen(false);
			z2.setZavrsitiDo(new Date(114,6,20));
			z2.setHitnost("SREDNJA");
			z2.setZahtjevPodnesen(new Date(114,6,6));
			
			//dodijeljen drugom uposleniku
			Zadatak z3=new Zadatak();
			z3.setDonijetiUredjajDo(new Date(114,6,8));
			z3.setZahtjev(zahtjev);
			z3.setServiser(up2);
			z3.setZavrsen(false);
			z3.setZavrsitiDo(new Date(114,6,20));
			z3.setHitnost("SREDNJA");
			z3.setZahtjevPodnesen(new Date(114,6,6));
			
			//dodavanja u bazu
			HibernateUposlenik huposlenik=new HibernateUposlenik();
			huposlenik.dodajUposlenika(up);
			huposlenik.dodajUposlenika(up2);
			
			HibernateUredjaj huredjaj=new HibernateUredjaj();
			huredjaj.dodajUredjaj(u);
			
			HibernateZahtjev hzahtjev1=new HibernateZahtjev();
			hzahtjev1.dodajZahtjev(zahtjev);
			
			HibernateZadatak hzadatak1=new HibernateZadatak();
			hzadatak1.dodajZadatak(z);
			hzadatak1.dodajZadatak(z2);
			hzadatak1.dodajZadatak(z3);
			
			//ukoliko je u bazi vec dodavano zadataka postavljamo broj zadataka na samo nasa tri kako bismo mogli provjeriti velicinu niza nezavrsenih zadataka
			int ukupno=0;
			if (hzadatak1.dajSveZadatke().size()>3)ukupno=hzadatak1.dajSveZadatke().size()-3;
			//testiranje ispravnosti vracanja svih zadataka
			Assert.assertTrue(hzadatak1.dajSveZadatke().size()-ukupno==3);
			z2.setZavrsen(true);
			hzadatak1.updateZadatak(z2);
			Assert.assertTrue(hzadatak1.dajSveZadatke().size()-ukupno==3);
			
			//testiranje ispravnosti vracanja zadataka prema uposlenicima
			Assert.assertTrue(hzadatak1.dajSveZadatke(up).size()==2);
			Assert.assertTrue(hzadatak1.dajSveZadatke(up2).size()==1);
			z3.setZavrsen(true);
			hzadatak1.updateZadatak(z3);
			Assert.assertTrue(hzadatak1.dajSveZadatke(up2).size()==1);
			
			//ciscenje baze
			hzadatak1.brisiZadatak(z);
			hzadatak1.brisiZadatak(z2);
			hzadatak1.brisiZadatak(z3);
			hzahtjev1.brisiZahtjev(zahtjev);
			huredjaj.brisiUredjaj(u);
			huposlenik.brisiUposlenika(up);
			huposlenik.brisiUposlenika(up2);

		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
