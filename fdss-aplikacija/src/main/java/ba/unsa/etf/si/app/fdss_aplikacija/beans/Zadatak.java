package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.sql.Date;

public class Zadatak implements Serializable{
	
	long id;
	Uredjaj uredaj;
	Uposlenik serviser;
	
	String redniBroj;
	Date zavrsitiDo;
	Date zahtjevPodnesen;
	Date donijetiUredjajDo;
	
	boolean zavrsen;

	public Zadatak() {
		uredaj=new Uredjaj();
		serviser=new Uposlenik();
	}

	public boolean isZavrsen() {
		return zavrsen;
	}



	public void setZavrsen(boolean zavrsen) {
		this.zavrsen = zavrsen;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Uredjaj getUredjaj() {
		return uredaj;
	}



	public void setUredjaj(Uredjaj uredaj) {
		this.uredaj = uredaj;
	}



	public Uposlenik getServiser() {
		return serviser;
	}



	public void setServiser(Uposlenik serviser) {
		this.serviser = serviser;
	}



	public String getRedniBroj() {
		return redniBroj;
	}



	public void setRedniBroj(String redniBroj) {
		this.redniBroj = redniBroj;
	}



	public Date getZavrsitiDo() {
		return zavrsitiDo;
	}



	public void setZavrsitiDo(Date zavrsitiDo) {
		this.zavrsitiDo = zavrsitiDo;
	}



	public Date getZahtjevPodnesen() {
		return zahtjevPodnesen;
	}



	public void setZahtjevPodnesen(Date zahtjevPodnesen) {
		this.zahtjevPodnesen = zahtjevPodnesen;
	}



	public Date getDonijetiUredajDo() {
		return donijetiUredjajDo;
	}



	public void setDonijetiUredajDo(Date donijetiUredajDo) {
		this.donijetiUredjajDo = donijetiUredajDo;
	}



	@Override
	public boolean equals(Object obj) {
		 if (this == obj)
	           return true;
	       if (obj == null)
	           return false;
	       if (getClass() != obj.getClass())
	           return false;
	       final Zadatak other = (Zadatak) obj;
	       if (id !=other.getId())
	           return false;
	       return true;
	   }
}
