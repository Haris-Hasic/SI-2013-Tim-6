package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateUposlenik {
	
	public HibernateUposlenik() {
		
	}
	
	public static void dodajUposlenika(Uposlenik u) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Long id = (Long)session.save(u);
		t.commit();
		
		session.close();
	}
	
	public static Uposlenik dajUposlenika(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Uposlenik u = (Uposlenik)session.get(Uposlenik.class, id);
		
		if(u == null) {
			
			session.close();
			return null;
		}
		
		else {
			
			session.close();
			return u;
		}
	}
	
	public static boolean postojiUposlenik(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Uposlenik u = (Uposlenik)session.get(Uposlenik.class, id);
		
		if(u == null) {
			
			session.close();
			return false;
		}
		
		else {
			
			session.close();
			return true;
		}
	}
	
	public static List<Uposlenik> vratiSveUposlenike() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		List<Uposlenik> lista = session.createCriteria(Uposlenik.class).list();
		
		session.close();
		return lista;
	}

}
