package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import org.junit.*;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;

public class UredjajTest {
	
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
			u.setJibProizvodaca("2706992172174");
			Assert.assertEquals("2706992172174", u.getJibProizvodaca());
		}
		catch (GeneralniException e) 
		{
			Assert.fail("Greska u get i set metodama JIB_Proizvodjaca atributa.");
		}
		
	}
	
	@Test
	public void testGetSetJIBProizvodjacaNeispravno() {
		Uredjaj u = new Uredjaj();
		try {
			u.setJibProizvodaca("2706992172174");
			u.setJibProizvodaca("2706992172170");
			Assert.fail("Greska u get i set metodama JIB_Proizvodjaca atributa.");
		}
		catch (GeneralniException e) 
		{
			Assert.assertEquals("2706992172174", u.getJibProizvodaca());
		}
		
	}
	

}
