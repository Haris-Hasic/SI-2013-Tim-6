package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateKlijent{
	Session session;
	Transaction t;
	
	public HibernateKlijent() {

	}
	
	
	
	public void dodajKlijenta(Klijent k) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Long id = (Long)session.save(k);
		t.commit();	
		
		session.close();
	}
	
	public void updateKlijenta(Klijent k) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		session.update(k);
		t.commit();
		
		session.close();
		
	}
	
	public Klijent dajKlijenta(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Klijent k = (Klijent)session.get(Klijent.class, id);
		
		
		if(k == null) {
			session.close();
			return new Klijent();
			
		}
		
		else {
			session.close();
			k.setUredjaji(new HibernateUredjaj().dajSveUredjaje(k));
			return k;
		}
	}
	
	public Klijent dajKlijenta(String JIB) {
	
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Query query = session.createQuery("from Klijent where jib = :tempJib");
		query.setParameter("tempJib", JIB);
		List<Klijent> temp=query.list();
		

		if(temp.size() == 0) {
			session.close();
			return new Klijent();
		}
		session.close();
		Klijent k=(Klijent)temp.get(0);
		List<Uredjaj> l=new HibernateUredjaj().dajSveUredjaje(k);
		k.setUredjaji(l);
		return k;
	
	}
	
	public boolean postojiKlijent(String JIB) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Query query = session.createQuery("from Klijent where jib = :tempJib");
		query.setParameter("tempJib", JIB);
		
		if(query.list().size()==0) {
			session.close();
			return false;
		}
		
		else {
			session.close();
			return true;
		}
	}

	public List<Klijent> dajSveKlijente() throws HibernateException
	{
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
			
		List<Klijent> temp=new ArrayList<Klijent>();
		temp=session.createCriteria(Klijent.class).list();
		if(temp.size()==0) {
			session.close();
			return new ArrayList<Klijent>();
		}
			session.close();
			for(Klijent k:temp)
			{
				k.setUredjaji(new HibernateUredjaj().dajSveUredjaje(k));
			}
		return temp;
	}
	
	public boolean postojiKlijent(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Klijent u = (Klijent)session.get(Klijent.class, id);
		
		if(u == null) {
			session.close();
			return false;
		}
		
		else {
			session.close();
			return true;
		}
	}
	
	public List<Klijent> vratiSveKlijente() {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		List<Klijent> lista= session.createCriteria(Klijent.class).list();
		
		session.close();
		return lista;
	}

	public void brisiKlijenta(Klijent k) {
			session= HibernateUtil.getSessionFactory().openSession();
			t= session.beginTransaction();
			
			session.delete(k);
			t.commit();
			
			session.close();
		}
	
	}
