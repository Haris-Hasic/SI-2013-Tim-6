package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.util.List;

public class Uposlenik {
	
	private String _ime;
	private String _prezime;
	private int _JIB;
	private String _adresa;
	private String _mjesto;
	private String _telefon;
	private String _email;
	
	private int _privilegija;
	
	TipUposlenika _tip;
	
	private String _userName;
	private String _password;
	
	Uposlenik() {
		
	}

	public String get_ime() {
		return _ime;
	}

	public void set_ime(String _ime) {
		this._ime = _ime;
	}

	public String get_prezime() {
		return _prezime;
	}

	public void set_prezime(String _prezime) {
		this._prezime = _prezime;
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

	public int get_privilegija() {
		return _privilegija;
	}

	public void set_privilegija(int _privilegija) {
		this._privilegija = _privilegija;
	}

	public TipUposlenika get_tip() {
		return _tip;
	}

	public void set_tip(TipUposlenika _tip) {
		this._tip = _tip;
	}

	public String get_userName() {
		return _userName;
	}

	public void set_userName(String _userName) {
		this._userName = _userName;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

}
