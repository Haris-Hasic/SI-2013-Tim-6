package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.util.List;

public class Klijent {
	
	private String _naziv;
	private String _tip;
	private int _JIB;
	private String _adresa;
	private String _mjesto;
	private String _telefon;
	private String _email;
	private String _web;
	private List<Uredaj> _listaUredaja;
	
	Klijent() {
		
	}
	
	public String get_naziv() {
		return _naziv;
	}

	public void set_naziv(String _naziv) {
		this._naziv = _naziv;
	}

	public String get_tip() {
		return _tip;
	}

	public void set_tip(String _tip) {
		this._tip = _tip;
	}

	public int get_JIB() {
		return _JIB;
	}

	public void set_JIB(int _JIB) {
		this._JIB = _JIB;
	}

	public String get_adresa() {
		return _adresa;
	}

	public void set_adresa(String _adresa) {
		this._adresa = _adresa;
	}

	public String get_mjesto() {
		return _mjesto;
	}

	public void set_mjesto(String _mjesto) {
		this._mjesto = _mjesto;
	}

	public String get_telefon() {
		return _telefon;
	}

	public void set_telefon(String _telefon) {
		this._telefon = _telefon;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String _email) {
		this._email = _email;
	}

	public String get_web() {
		return _web;
	}

	public void set_web(String _web) {
		this._web = _web;
	}

	public List<Uredaj> get_listaUredaja() {
		return _listaUredaja;
	}

	public void set_listaUredaja(List<Uredaj> _listaUredaja) {
		this._listaUredaja = _listaUredaja;
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
	       if (_JIB != other.get_JIB())
	           return false;
	       return true;
	   }
}
