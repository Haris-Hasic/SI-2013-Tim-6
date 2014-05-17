package ba.unsa.etf.si.app.fdss_aplikacija.klase;

import java.util.List;

public class Servis {
	
	List<Klijent> _klijenti;
	List<Uposlenik> _uposlenici;
	List<Zadatak> _zadaci;
	
	Servis() {
		Uposlenik u1=new Uposlenik();
		u1.set_ime("uposlenik 1");
		_uposlenici.add(u1);
		
		Uposlenik u2=new Uposlenik();
		u2.set_ime("ovako za sve ostalo");
		_uposlenici.add(u2);
	}
	
	public List<Uposlenik> dajUposlenike()
	{
		return _uposlenici;
	}
	
	public void dodajUposlenika(Uposlenik _uposlenik)
	{
		_uposlenici.add(_uposlenik);
	}
	public void obrisiUposlenika(Uposlenik _uposlenik)
	{
		for (int i=0;i<_uposlenici.size();i++)
		{
			if (_uposlenici.get(i).get_userName().equals(_uposlenik.get_userName()))
			{
				_uposlenici.remove(i);
				break;
			}
		}
	}
	
	//na ovaj nacin cemo ih forsirati da koriste Servis, odnosno pristup bazi ispravno i to je to
	
}
