package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateZadatak {
	
	public HibernateZadatak() {
		
	}
	
	
	public void dodajZadatak(Zadatak z) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Long id = (Long)session.save(z);
		t.commit();
		
		session.close();
	}
	
	public  List<Zadatak> dajSveNezavrseneZadatke() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from Zadatak where zavrsen = :tZavrsen");
		query.setParameter("tZavrsen", false);
		List<Zadatak> temp=query.list();
		
		if(temp.size() == 0) {
			
			session.close();
			return null;
		}

		session.close();
		return temp ;

	}
	
	public  List<Zadatak> dajSveNezavrseneZadatke(Uposlenik serviser)
	{
		List<Zadatak> temp=dajSveNezavrseneZadatke();
		if(temp.size() == 0) {
			
			new ArrayList<Zadatak>();
		}
		List<Zadatak> lista=new ArrayList<Zadatak>();
		for(Zadatak z:temp)
		{
			if(z.getServiser().getId()==serviser.getId())
			{
				lista.add(z);
			}
		}
		return lista ;
	}
	public void updateZadatak(Zadatak z) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(z);
		t.commit();
		
		session.close();
	}
	
	public Zadatak dajZadatak(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Zadatak z = (Zadatak)session.get(Zadatak.class, id);
		
		if(z == null) {
			
			session.close();
			return null;
		}
		
		else {
			
			session.close();
			return z;
		}
	}
	

	public List<Zadatak> dajSveZadatke()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Zadatak> temp=new ArrayList<Zadatak>();
		Transaction t = session.beginTransaction();
		
		temp=session.createCriteria(Zadatak.class).list();
		if(temp.size()==0) {
			
			session.close();
			return null;
		}
		session.close();
		return temp;
	}
	public boolean postojiZadatak(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Zadatak u = (Zadatak)session.get(Zadatak.class, id);
		
		if(u == null) {
			
			session.close();
			return false;
		}
		
		else {
			
			session.close();
			return true;
		}
	}
	
	public List<Zadatak> vratiSveZadatke() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		List<Zadatak> lista= session.createCriteria(Zadatak.class).list();
		
		session.close();
		return lista;
	}

	public void brisiZadatak(Zadatak u) {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Transaction t = session.beginTransaction();
			session.delete(u);
			t.commit();
			session.close();
		}
	
	}
