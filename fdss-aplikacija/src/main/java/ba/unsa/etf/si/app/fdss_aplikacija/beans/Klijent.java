package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

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
		
		List<Uredjaj> uredjaji;
	}
	
	public Klijent(String n, String tp, String j, String a, String m, String t, String e, String w) throws GeneralniException {
		
		setNaziv(n);
		setTip(tp);
		setJib(j);
		setAdresa(a);
		setMjesto(m);
		setTelefon(t);
		setEmail(e);
		setWeb(w);
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

	public void setJib(String jib) throws GeneralniException {

		if(jib.length() == 12)
			this.jib = jib;
		
		else
			throw new GeneralniException("Nepravilan format JIB ! (tačno 12 brojeva)");
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) throws GeneralniException {
		
		if(Validacija.validirajWeb(web))
			this.web = web;
		
		else
			throw new GeneralniException("Nepravilan format web adrese ! (npr. www.nesto.com)");
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
