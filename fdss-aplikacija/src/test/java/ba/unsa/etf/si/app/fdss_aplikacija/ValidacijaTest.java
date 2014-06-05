package ba.unsa.etf.si.app.fdss_aplikacija;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

import org.junit.*;

public class ValidacijaTest {
	
	@Test
	public void TestValidirajJMBG() 
	{
		String jmb = "2706992172174";
		Assert.assertTrue(Validacija.validirajJMBG(jmb));
	}
	
	@Test
	public void TestValidirajPogresanJMBG() 
	{
		String jmb = "1234567890";
		Assert.assertFalse(Validacija.validirajJMBG(jmb));
	}
	
	@Test
	public void TestValidirajIBFM() 
	{
		String ibfm = "AB021765";
		Assert.assertTrue(Validacija.validirajIBFM(ibfm));
	}
	
	@Test
	public void TestValidirajPogresanIBFM() 
	{
		String ibfm = "123456AB";
		Assert.assertFalse(Validacija.validirajIBFM(ibfm));
	}
	
	@Test
	public void TestValidirajIBFU() 
	{
		String ibfu = "EO021760";
		Assert.assertTrue(Validacija.validirajIBFU(ibfu));
	}
	
	@Test
	public void TestValidirajPogresanIBFU() 
	{
		String ibfu = "HH021761";
		Assert.assertFalse(Validacija.validirajIBFU(ibfu));
	}
	
	@Test
	public void TestValidirajIme() 
	{
		String ime = "Haris";
		Assert.assertTrue(Validacija.validirajIme(ime));
	}
	
	@Test
	public void TestValidirajPogresnoIme() 
	{
		String ime = "     12sasa";
		Assert.assertFalse(Validacija.validirajIme(ime));
	}
	
	@Test
	public void TestValidirajPrezime() 
	{
		String ime = "Jean-Paul";
		Assert.assertTrue(Validacija.validirajPrezime(ime));
		ime = "Hasic";
		Assert.assertTrue(Validacija.validirajPrezime(ime));
	}
	
	@Test
	public void TestValidirajPogresnoPrezime() 
	{
		String ime = "   sdaa  12sasa";
		Assert.assertFalse(Validacija.validirajPrezime(ime));
	}
	
	@Test
	public void TestValidirajAdresu() 
	{
		String adresa = "Tuzlanska br5";
		Assert.assertTrue(Validacija.validirajAdresa(adresa));
	}
	
	@Test
	public void TestValidirajPogresnaAdresa() 
	{
		String adresa = "---adsdadsdas----";
		Assert.assertFalse(Validacija.validirajAdresa(adresa));
	}
	
	@Test
	public void TestValidirajGrad() 
	{
		String grad = "Los Angeles";
		Assert.assertTrue(Validacija.validirajGrad(grad));
		grad = "Olovo";
		Assert.assertTrue(Validacija.validirajGrad(grad));
	}
	
	@Test
	public void TestValidirajPogresanGrad() 
	{
		String grad = "---adsdadsdas----";
		Assert.assertFalse(Validacija.validirajGrad(grad));
	}
	
	@Test
	public void TestValidirajEmail() 
	{
		String email = "kahrovic@hotmail.com";
		Assert.assertTrue(Validacija.validirajEmail(email));
	}
	
	@Test
	public void TestValidirajPogresanEmail() 
	{
		String email = "kahrovic@.com";
		Assert.assertFalse(Validacija.validirajEmail(email));
	}
	
	@Test
	public void TestValidirajWeb() 
	{
		String web = "www.google.com";
		Assert.assertTrue(Validacija.validirajWeb(web));
		web = "www.klix.ba";
		Assert.assertTrue(Validacija.validirajWeb(web));
		web = "www.usarmy.arpa";
		Assert.assertTrue(Validacija.validirajWeb(web));
	}
	
	@Test
	public void TestValidirajPogresanWeb() 
	{
		String web = "   12312#fdsff";
		Assert.assertFalse(Validacija.validirajWeb(web));
	}
	
	@Test
	public void TestValidirajTelefon() 
	{
		String telefon = "+38761503098";
		Assert.assertTrue(Validacija.validirajTelefon(telefon));
	}
	
	@Test
	public void TestValidirajPogresanTelefon() 
	{
		String telefon = "+38761";
		Assert.assertFalse(Validacija.validirajTelefon(telefon));
	}
	
	@Test
	public void TestHesirajMD5() 
	{
		String poruka = "nekaPoruka";
		Assert.assertEquals("846010891eb0ecd2103dcc26320c6f20", Validacija.HesirajMD5(poruka));
	}
	
	@Test
	public void TestPogresanHesirajMD5() 
	{
		String poruka = "nekaPoruka";
		Assert.assertNotSame("846010891eb0ecd2103dcc26320c6f21", Validacija.HesirajMD5(poruka));
	}
}
