package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.sql.Date;

public class Zahtjev {
	
	private Uredaj _uredaj;
	
	private int _redniBroj;
	private Date _zahtjevPodnesen;
	
	Zahtjev() {
	
	}

	public Uredaj get_uredaj() {
		return _uredaj;
	}

	public void set_uredaj(Uredaj _uredaj) {
		this._uredaj = _uredaj;
	}

	public int get_redniBroj() {
		return _redniBroj;
	}

	public void set_redniBroj(int _redniBroj) {
		this._redniBroj = _redniBroj;
	}

	public Date get_zahtjevPodnesen() {
		return _zahtjevPodnesen;
	}

	public void set_zahtjevPodnesen(Date _zahtjevPodnesen) {
		this._zahtjevPodnesen = _zahtjevPodnesen;
	}

}
