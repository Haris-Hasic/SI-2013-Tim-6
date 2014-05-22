package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.*;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;

public class Servis {
	
	List<Klijent> _klijenti;
	List<Zahtjev> _zahthevi;
	public Servis() {
	
	}
	public List<Zahtjev> get_zahthevi() {
		return new HibernateZahtjev().dajSveNezavrseneZahtjeve();
	}
	public List<Klijent> get_klijenti() {
		return new HibernateKlijent().dajSveKlijente();
	}
		
}
