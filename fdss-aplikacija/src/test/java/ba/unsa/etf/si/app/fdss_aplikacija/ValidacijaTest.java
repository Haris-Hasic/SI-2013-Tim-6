package ba.unsa.etf.si.app.fdss_aplikacija;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

import org.junit.*;

public class ValidacijaTest {
	@Test
	public void TestValidirajJMBG() 
	{
		String jmb = "2706992172174";
		Boolean rezultat = Validacija.validirajJMBG(jmb);
		Assert.assertTrue(rezultat);
	}
	
	@Test
	public void TestValidirajJMBG2() 
	{
		String jmb = "2706992172175";
		Boolean rezultat = Validacija.validirajJMBG(jmb);
		Assert.assertFalse(rezultat);
	}
	
	
	@Test
	public void TestValidirajIBFM() 
	{
		String ibfm = "EO021760";
		Boolean rezultat = Validacija.validirajIBFM(ibfm);
		Assert.assertTrue(rezultat);
	}
	
	@Test
	public void TestValidirajIBFM2() 
	{
		String ibfm = "EOL21760";
		Boolean rezultat = Validacija.validirajIBFM(ibfm);
		Assert.assertFalse(rezultat);
	}
	
	@Test
	public void TestValidirajIBFU() 
	{
		String ibfu = "EO021760";
		Boolean rezultat = Validacija.validirajIBFU(ibfu);
		Assert.assertTrue(rezultat);
	}
	
	@Test
	public void TestValidirajIBFU2() 
	{
		String ibfu = "EO021761";
		Boolean rezultat = Validacija.validirajIBFU(ibfu);
		Assert.assertFalse(rezultat);
	}
	
	
	@Test
	public void TestValidirajEmail() 
	{
		String email = "kahrovic@hotmail.com";
		Boolean rezultat = Validacija.validirajEmail(email);
		Assert.assertTrue(rezultat);
	}
	
	@Test
	public void TestValidirajEmail2() 
	{
		String email = "kahrovic@.com";
		Boolean rezultat = Validacija.validirajEmail(email);
		Assert.assertFalse(rezultat);
	}
	
	@Test
	public void TestValidirajTelefon() 
	{
		String telefon = "+38761503098";
		Boolean rezultat = Validacija.validirajTelefon(telefon);
		Assert.assertTrue(rezultat);
	}
	
	@Test
	public void TestValidirajTelefon2() 
	{
		String telefon = "+38761";
		Boolean rezultat = Validacija.validirajTelefon(telefon);
		Assert.assertFalse(rezultat);
	}
	
	@Test
	public void TestHesirajMD5() 
	{
		String poruka = "nekaPoruka";
		String hesirano = Validacija.HesirajMD5(poruka);
		Assert.assertEquals("846010891eb0ecd2103dcc26320c6f20", hesirano);
	}
	
	@Test
	public void TestHesirajMD52() 
	{
		String poruka = "nekaPoruka";
		String hesirano = Validacija.HesirajMD5(poruka);
		Assert.assertNotSame("846010891eb0ecd2103dcc26320c6f21", hesirano);
	}
	


}
