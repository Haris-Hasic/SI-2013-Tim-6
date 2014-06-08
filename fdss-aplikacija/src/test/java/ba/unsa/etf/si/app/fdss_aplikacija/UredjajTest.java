package ba.unsa.etf.si.app.fdss_aplikacija;
import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;

import org.junit.*;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class UredjajTest {
	Uredjaj ur;
	HibernateUredjaj hur;
	@Before
	public void TestnePostavke () {
		try {
			ur =  new Uredjaj();
			ur.setIbfu("EO021760");
			ur.setIbfm("EO021760");
			ur.setId(123);
			ur.setTipUredaja("kasa");
			ur.setJibProizvodaca("270699217217");
		}
		
		catch (GeneralniException e)
		{
			Validacija v= new Validacija();
			v.poruka(e.getMessage());
		}
		
		hur = new HibernateUredjaj();
	}
	
	@Test
	public void testGetSetIBFU() {
		Uredjaj u = new Uredjaj();
		try {
			u.setIbfu("EO021760");
			Assert.assertEquals("EO021760", u.getIbfu());
		}
		catch (GeneralniException e) 
		{
			Assert.fail("Greska u get i set metodama IBFU atributa.");
		}
		
	}
	
	@Test
	public void testGetSetIBFUNeispravno() {
		Uredjaj u = new Uredjaj();
		try {
			u.setIbfu("EO021760");
			u.setIbfu("EO021761");
			Assert.fail("Greska u get i set metodama IBFU atributa.");
		}
		catch (GeneralniException e) 
		{
			Assert.assertEquals("EO021760", u.getIbfu());
		}
		
	}
	
	@Test
	public void testGetSetIBFM() {
		Uredjaj u = new Uredjaj();
		try {
			u.setIbfm("EO021760");
			Assert.assertEquals("EO021760", u.getIbfm());
		}
		catch (GeneralniException e) 
		{
			Assert.fail("Greska u get i set metodama IBFM atributa.");
		}
		
	}
	
	@Test
	public void testGetSetIBFMNeispravno() {
		Uredjaj u = new Uredjaj();
		try {
			u.setIbfm("EO021760");
			u.setIbfm("EOL21760");
			Assert.fail("Greska u get i set metodama IBFM atributa.");
		}
		catch (GeneralniException e) 
		{
			Assert.assertEquals("EO021760", u.getIbfm());
		}
		
	}
	
	@Test
	public void testGetSetJIBProizvodjaca() {
		Uredjaj u = new Uredjaj();
		try {
			u.setJibProizvodaca("270699217217");
			Assert.assertEquals("270699217217", u.getJibProizvodaca());
		}
		catch (GeneralniException e) 
		{
			Assert.fail("Greska u get i set metodama JIB_Proizvodjaca atributa.");
		}
		
	}

	@Test
	public void testBrisanjeUredjaja() {
		Uredjaj urNovi =  new Uredjaj();
		try {
			urNovi.setIbfu("EO021760");
		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			urNovi.setIbfm("EO021761");
		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		urNovi.setId(124);
		urNovi.setTipUredaja("kasa");
		try {
			urNovi.setJibProizvodaca("270699217215");
		} catch (GeneralniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			hur.dodajUredjaj(urNovi);
			hur.brisiUredjaj(urNovi);
			Assert.assertFalse(hur.postojiUredjaj("EO021760"));
	}
	public void testDodajUredjaj()
	{
		hur.dodajUredjaj(ur);
		Assert.assertTrue(hur.postojiUredjaj(ur.getId()));
		hur.brisiUredjaj(ur);
	}
	@Test
	public void testUpdateUredjaja() {
		
		
		
		try {
			hur.dodajUredjaj(ur);//IFBU= EO021760
			
			Uredjaj tmp1=hur.dajUredjaj("EO021760");
			tmp1.setIbfu("EO123450");
			hur.updateUredjaj(tmp1);
			
			Uredjaj tmp2=hur.dajUredjaj("EO123450");
					
			Boolean flag=false;
			if(tmp1.getId()==tmp2.getId())
				flag=true;
			hur.brisiUredjaj(ur);
			Assert.assertTrue(flag);
		} 
		
		catch (GeneralniException e) {
			
			Assert.fail("Test neuspješan. Poruka: "+e.getMessage());
		}
	}
}
