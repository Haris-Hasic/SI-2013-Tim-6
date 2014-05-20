package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.sql.Date;

public class Zahtjev implements Serializable {
	
	long id;
	Uredjaj uredjaj;
	Date zahtjevPodnesen;
	
	boolean zavrsen;
	
	public Zahtjev() {
		uredjaj=new Uredjaj();
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Uredjaj getUredjaj() {
		return uredjaj;
	}


	public void setUredjaj(Uredjaj uredjaj) {
		this.uredjaj = uredjaj;
	}


	public Date getZahtjevPodnesen() {
		return zahtjevPodnesen;
	}


	public void setZahtjevPodnesen(Date zahtjevPodnesen) {
		this.zahtjevPodnesen = zahtjevPodnesen;
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
	       final Zahtjev other = (Zahtjev) obj;
	       if (id != other.getId())
	           return false;
	       return true;
	   }

}
