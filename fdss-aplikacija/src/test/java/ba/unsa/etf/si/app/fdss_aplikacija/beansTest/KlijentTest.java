package ba.unsa.etf.si.app.fdss_aplikacija.beansTest;


import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;





import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;

public class KlijentTest extends TestCase {

public void testGetSetJmbgIspravno() {
		
		try {
	
			Klijent k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
			k.setJib("1607991186528");
			
			assertEquals("1607991186528", k.getJib());
		} 
		
		catch (GeneralniException e) {
			
			fail("Test neuspješan. Ne rade get i set metode za atribut Jib.");
		}
	}


public void testGetSetJibNeispravno() {
	
	Klijent k = new Klijent();
	
	try {
		
		k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
		k.setJib("1607");
		
		Assert.fail("Test neuspješan. Ne rade get i set metode za atribut jmbg.");
	} 
	
	catch (GeneralniException e) {
		
		Assert.assertEquals("1607991186528", k.getJib());
	}
}

public void testGetSetWebIspravno() {
	
	try {

		Klijent k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
		k.setWeb("firma.com");
		
		assertEquals("firma.com", k.getWeb());
	} 
	
	catch (GeneralniException e) {
		
		fail("Test neuspješan. Ne rade get i set metode za atribut Web .");
	}
}


public void testGetSetMjestoIspravno() {
	
	try {

		Klijent k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
		k.setMjesto("Sarajevo");
		
		assertEquals("Sarajevo", k.getMjesto());
	} 
	
	catch (GeneralniException e) {
		
		fail("Test neuspješan. Ne rade get i set metode za atribut Mjesto .");
	}
}



 void testGetSetEmail() {
	
	 Klijent k = new Klijent();
	 
	try {
		
		k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
		k.setEmail("eganilovic1@etf.unsa.ba");
		
		Assert.assertEquals("eganilovic1@etf.unsa.ba", k.getEmail());
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne rade get i set metode za atribut e-mail.");
	}
}

@Test
public void testUpdateKlijenta() {
	
	Klijent k = new Klijent();
	
	try {
		
		k = new Klijent("Firma", "1607991186528", "Dervisa Susica 2", "Brcko", "+38761579652", "ena_brcko@hotmail.com","firma.ba");
		k.setAdresa("Trg djece Dobrinje");
		k.setMjesto("Sarajevo");
		k.setNaziv("Firma");
		k.setJib("2706992172174");
		k.setEmail("firma@hotmail.com");
		k.setTelefon("+38761503098");
		k.setWeb("firma.com");
	
		
		Boolean flag=false;
		if (k.getAdresa()=="Trg djece Dobrinje" && k.getMjesto()=="Sarajevo" && k.getNaziv()=="Firma"  && k.getJib()=="2706992172174" && k.getEmail()=="firma@hotmail.com" && k.getTelefon()=="+38761503098")
			flag=true;
		
		Assert.assertTrue(flag);
	} 
	
	catch (GeneralniException e) {
		
		Assert.fail("Test neuspješan. Ne radi update-ovanje klijenta.");
	}
}


public void testpostojiKlijent() {
	
	HibernateKlijent h  = new HibernateKlijent();
	
	assertEquals((Boolean)true,(Boolean) h.postojiKlijent("1607991186528"));
	
}

}
