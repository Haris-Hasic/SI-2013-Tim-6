package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.TipUposlenika;

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

	public void setJib(String jib) {
		this.jib = jib;
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
							// if(u.getPrivilegija==TipUposlenika.ADMINISTRATOR)....
							// ili t.setPrivilegija(TipUposlenika.SERVISER)
	
	public void setTip(int tip) {
		this.tip = tip;
	}
	
	public TipUposlenika getPrivilegija()
	{
		switch(tip)
		{
			case 1:
				return TipUposlenika.ADMINISTRATOR;
			case 2:
				return TipUposlenika.DISPECER;
			case 3:
				return TipUposlenika.MENADZER;
			case 4:
				return TipUposlenika.SERVISER;
			default:
				return null;
		}
	}
	
	public void SetPrivilegija(TipUposlenika tipUposlenika)
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

}
