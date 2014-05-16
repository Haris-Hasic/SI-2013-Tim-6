package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.sql.Date;

public class Zadatak {
	
	private Uredaj _uredaj;
	private Uposlenik _serviser;
	
	private int _redniBroj;
	private Date _zavrsitiDo;
	private Date _zahtjevPodnesen;
	private Date _donijetiUredajDo;
	
	Zadatak() {
	
	}

	public Uredaj get_uredaj() {
		return _uredaj;
	}

	public void set_uredaj(Uredaj _uredaj) {
		this._uredaj = _uredaj;
	}

	public Uposlenik get_serviser() {
		return _serviser;
	}

	public void set_serviser(Uposlenik _serviser) {
		this._serviser = _serviser;
	}

	public int get_redniBroj() {
		return _redniBroj;
	}

	public void set_redniBroj(int _redniBroj) {
		this._redniBroj = _redniBroj;
	}

	public Date get_zavrsitiDo() {
		return _zavrsitiDo;
	}

	public void set_zavrsitiDo(Date _zavrsitiDo) {
		this._zavrsitiDo = _zavrsitiDo;
	}

	public Date get_zahtjevPodnesen() {
		return _zahtjevPodnesen;
	}

	public void set_zahtjevPodnesen(Date _zahtjevPodnesen) {
		this._zahtjevPodnesen = _zahtjevPodnesen;
	}

	public Date get_donijetiUredajDo() {
		return _donijetiUredajDo;
	}

	public void set_donijetiUredajDo(Date _donijetiUredajDo) {
		this._donijetiUredajDo = _donijetiUredajDo;
	}
}
