package ba.unsa.etf.si.app.fdss_aplikacija;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ValidacijaTest extends TestCase {
	
    public ValidacijaTest( String testName )
    {
        super( testName );
    }
    
    public static Test suite()
    {
        return new TestSuite( ValidacijaTest.class );
    }
	
	public void TestValidirajJMBG() 
	{
		String jmb = "2706992172174";
		Boolean rezultat = Validacija.validirajJMBG(jmb);
		Assert.assertTrue(rezultat);
	}
	
	public void TestValidirajJMBG2() 
	{
		String jmb = "2706992172175";
		Boolean rezultat = Validacija.validirajJMBG(jmb);
		Assert.assertFalse(rezultat);
	}

	public void TestValidirajIBFM() 
	{
		String ibfm = "EO021760";
		Boolean rezultat = Validacija.validirajIBFM(ibfm);
		Assert.assertTrue(rezultat);
	}
	
	public void TestValidirajIBFM2() 
	{
		String ibfm = "EOL21760";
		Boolean rezultat = Validacija.validirajIBFM(ibfm);
		Assert.assertFalse(rezultat);
	}
	
	

}
