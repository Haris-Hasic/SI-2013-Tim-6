package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.PrivilegijaUposlenika;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class Uposlenik implements Serializable{
	
	long id;
	String ime;
	String prezime;
	String jmbg;
	String adresa;
	String mjesto;
	String telefon;
	String email;
	int tip;
	
	String userName;
	String password;
	
	public Uposlenik() {
		
	}
	
	public Uposlenik(String im, String pr, String j, String a, String m, String t, String e, int tp, String un, String p) throws GeneralniException {

			setIme(im);
			setPrezime(pr);
			setJmbg(j);
			setAdresa(a);
			setMjesto(m);
			setTelefon(t);
			setEmail(e);
			setTip(tp);
			setUserName(un);
			setPassword(p);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) throws GeneralniException {
		
		if(Validacija.validirajIme(ime))
			this.ime = ime;
		
		else
			throw new GeneralniException("Nepravilan format imena !");
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) throws GeneralniException {
		
		if(Validacija.validirajPrezime(prezime))
			this.prezime = prezime;
		
		else
			throw new GeneralniException("Nepravilan format prezimena !");
	}

	public String getJmbg() {
		
		return jmbg;
	}

	public void setJmbg(String jmbg) throws GeneralniException {
		
		if(Validacija.validirajJMBG(jmbg))
			this.jmbg = jmbg;
		
		else
			throw new GeneralniException("Nepravilan format JMBG !");
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) throws GeneralniException {
		
		if(Validacija.validirajAdresa(adresa))
			this.adresa = adresa;
		
		else
			throw new GeneralniException("Nepravilan format adrese ! (npr. Tuzlanska bb)");
	}

	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) throws GeneralniException {
		
		if(Validacija.validirajGrad(mjesto))
			this.mjesto = mjesto;
		
		else
			throw new GeneralniException("Nepravilan format grada ! (npr. Sarajevo)");
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) throws GeneralniException {
		
		if(Validacija.validirajTelefon(telefon))
			this.telefon = telefon;
		
		else
			throw new GeneralniException("Nepravilan format telefona ! (npr. +38733123456)");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws GeneralniException {
		
		if(Validacija.validirajEmail(email))
			this.email = email;
		
		else
			throw new GeneralniException("Nepravilan format e-maila ! (npr. nesto@nesto.com)");
	}

	public int getTip() {	// metode getTip i setTip nemojte koristi
		return tip;			// one sluze da ne bi morali enum ubacivati u bazu vec samo int
	}						// ukoliko vam treba njegov tip poristite metodu privilegija npr.
							// if(u.getPrivilegija==PrivilegijaUposlenika.ADMINISTRATOR)....
							// ili t.setPrivilegija(PrivilegijaUposlenika.SERVISER)
	
	public void setTip(int tip) {
		this.tip = tip;
	}
	
	public PrivilegijaUposlenika getPrivilegija()
	{
		switch(tip)
		{
			case 1:
				return PrivilegijaUposlenika.ADMINISTRATOR;
			case 2:
				return PrivilegijaUposlenika.DISPECER;
			case 3:
				return PrivilegijaUposlenika.MENADZER;
			case 4:
				return PrivilegijaUposlenika.SERVISER;
			default:
				return null;
		}
	}
	
	public void SetPrivilegija(PrivilegijaUposlenika tipUposlenika)
	{
		switch (tipUposlenika) {
			case ADMINISTRATOR:
				tip=1;
				break;
			case DISPECER:
				tip=2;
				break;
			case MENADZER:
				tip=3;
				break;
			case SERVISER:
				tip=4;
				break;
			default:
				break;
		}
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		String hash = Validacija.HesirajMD5(password);
		this.password = hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (this == obj)
	           return true;
	       if (obj == null)
	           return false;
	       if (getClass() != obj.getClass())
	           return false;
	       final Uposlenik other = (Uposlenik) obj;
	       if (id != other.getId())
	           return false;
	       return true;
	   }
	@Override
	public String toString()
	{
		return id + ". " + ime + " " + prezime + " - " + jmbg;
	}

}
