package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Klijent implements Serializable{
	
	long id;
	String naziv;
	String tip;
	String jib;
	String adresa;
	String mjesto;
	String telefon;
	String email;
	String web;
	List<Uredjaj> uredjaji;

	public List<Uredjaj> getUredjaji() {
		return uredjaji;
	}



	public void setUredjaji(List<Uredjaj> uredjaji) {
		this.uredjaji = uredjaji;
	}



	public Klijent() {
		
	}
	


	public long getId() {
		return id;
	}







	public void setId(long id) {
		this.id = id;
	}







	public String getNaziv() {
		return naziv;
	}





	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}





	public String getTip() {
		return tip;
	}





	public void setTip(String tip) {
		this.tip = tip;
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





	public String getWeb() {
		return web;
	}





	public void setWeb(String web) {
		this.web = web;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		 if (this == obj)
	           return true;
	       if (obj == null)
	           return false;
	       if (getClass() != obj.getClass())
	           return false;
	       final Klijent other = (Klijent) obj;
	       if (jib != other.getJib())
	           return false;
	       return true;
	   }
	@Override
	public String toString()
	{
		return naziv+" "+ tip;
	}
}
