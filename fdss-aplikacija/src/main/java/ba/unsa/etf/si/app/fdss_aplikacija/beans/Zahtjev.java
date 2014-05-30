package ba.unsa.etf.si.app.fdss_aplikacija.beans;

import java.io.Serializable;
import java.sql.Date;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Hitnost;

public class Zahtjev implements Serializable {
	
	long id;
	Uredjaj uredjaj;
	Date zahtjevPodnesen;
	Date rok;
	boolean zavrsen;
	int hitno;
	public Zahtjev() {
		uredjaj=new Uredjaj();
	}
	
	
	public Date getRok() {
		return rok;
	}


	public void setRok(java.util.Date rok) {

			this.rok = (Date) rok;
		
	}


	public int getHitno() {
		return hitno;
	}


	public void setHitno(int hitno) {
		this.hitno = hitno;
	}

	public Hitnost getHitnost() {
		switch (hitno) {
		case 0:
			return Hitnost.NISKA;
		case 1:
			return Hitnost.SREDNJA;
		default:
			return Hitnost.VELIKA;
		}
	}


	public void setHitnost(Hitnost hit) {
		switch (hit) {
		case NISKA:
			hitno=0;
			break;
		case SREDNJA:
			hitno=1;
			break;
		default:
			hitno=2;
			break;
		}
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


	public void setUredjaj(Uredjaj uredjaj) throws GeneralniException {
		if(uredjaj==null) throw new GeneralniException("Neispravan unos za uređaj.");
		this.uredjaj = uredjaj;
	}


	public Date getZahtjevPodnesen() {
		return zahtjevPodnesen;
	}


	public void setZahtjevPodnesen(java.util.Date sadasnji) {
		this.zahtjevPodnesen = (Date) sadasnji;
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
