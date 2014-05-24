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
	String jib;
	String adresa;
	String mjesto;
	String telefon;
	String email;
	int tip;
	
	String userName;
	String password;
	
	public Uposlenik() {
		
	}
	
	public Uposlenik(long i, String im, String pr, String j, String a, String m, String t, String e, int tp, String un, String p) throws GeneralniException {
		
			setId(i);
			setIme(im);
			setPrezime(pr);
			setJib(j);
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

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJib() {
		
		return jib;
	}

	public void setJib(String jib) throws GeneralniException {
		
		if(Validacija.validirajJMBG(jib))
			this.jib = jib;
		
		else
			throw new GeneralniException("Nepravilan format JMBG !");
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		this.password = password;
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
		return id + ". " + ime + " " + prezime + " - " + jib;
	}

}
