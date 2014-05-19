package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.sql.Date;

public class Zadatak implements Serializable{
	
	long id;
	Zahtjev zahtjev;
	Uposlenik serviser;
	
	String redniBroj;
	Date zavrsitiDo;
	Date zahtjevPodnesen;
	Date donijetiUredjajDo;
	String Hitnost;
	
	boolean zavrsen;

	public Zadatak() {
		
	}

	public String getHitnost() {
		return Hitnost;
	}

	public void setHitnost(String hitnost) {
		Hitnost = hitnost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Zahtjev getZahtjev() {
		return zahtjev;
	}

	public void setZahtjev(Zahtjev zahtjev) {
		this.zahtjev = zahtjev;
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

	public Date getDonijetiUredjajDo() {
		return donijetiUredjajDo;
	}

	public void setDonijetiUredjajDo(Date donijetiUredjajDo) {
		this.donijetiUredjajDo = donijetiUredjajDo;
	}

	public boolean isZavrsen() {
		return zavrsen;
	}

	public void setZavrsen(boolean zavrsen) {
		this.zavrsen = zavrsen;
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
