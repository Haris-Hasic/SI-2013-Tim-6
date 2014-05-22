package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateZahtjev {
	
	public HibernateZahtjev() {
		
	}
	
	public void dodajZahtjev(Zahtjev z) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Long id = (Long)session.save(z);
		t.commit();
		
		session.close();
	}
	
	public void updateZahtjev(Zahtjev z) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(z);
		t.commit();
		
		session.close();
	}
	
	public Zahtjev dajZahtjev(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Zahtjev u = (Zahtjev)session.get(Zahtjev.class, id);
		
		if(u == null) {
			
			session.close();
			return null;
		}
		
		else {
			
			session.close();
			return u;
		}
	}
	
	
public boolean postojiZahtjev(int redniBroj) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Zahtjev where redniBroj = :rb");
	query.setParameter("rb", redniBroj);
	
	if(query.list().size()==0) {
		
		session.close();
		return false;
	}
	
	else {
		
		session.close();
		return true;
	}
}

	public List<Zahtjev> dajSveZahtjeve()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Zahtjev> temp=new ArrayList<Zahtjev>();
		Transaction t = session.beginTransaction();
		
		temp=session.createCriteria(Zahtjev.class).list();
		if(temp.size()==0) {
			
			session.close();
			return null;
		}
		session.close();
		return temp;
	}
public  List<Zahtjev> dajSveNezavrseneZahtjeve() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from Zahtjev where zavrsen = :tZavrsen");
		query.setParameter("tZavrsen", false);
		List<Zahtjev> temp=query.list();
		
		if(temp.size() == 0) {
			
			session.close();
			return new ArrayList<Zahtjev>();
		}

		session.close();
		return temp ;

	}

	public boolean postojiZahtjev(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Zahtjev u = (Zahtjev)session.get(Zahtjev.class, id);
		
		if(u == null) {
			
			session.close();
			return false;
		}
		
		else {
			
			session.close();
			return true;
		}
	}
	
	public List<Zahtjev> vratiSveZahtjeve() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		List<Zahtjev> lista= session.createCriteria(Zahtjev.class).list();
		
		session.close();
		return lista;
	}

	public void brisiZahtjev(Zahtjev u) {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Transaction t = session.beginTransaction();
			session.delete(u);
			t.commit();
			session.close();
		}
	
	}
