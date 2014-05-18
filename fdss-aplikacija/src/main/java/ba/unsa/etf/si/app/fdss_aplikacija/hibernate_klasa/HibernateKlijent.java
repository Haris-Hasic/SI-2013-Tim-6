package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateKlijent{
	Session session;
	Transaction t;
	
	public HibernateKlijent() {
		session= HibernateUtil.getSessionFactory().openSession();
		
		t= session.beginTransaction();
	}
	
	
	@Override
	public void finalize() throws Throwable
	{
		try
		{
			session.close();
			
		}catch(Throwable t)
		{
			throw t;
		}
	}
	
	public void dodajKlijenta(Klijent k) {
		
		Long id = (Long)session.save(k);
		t.commit();	
	}
	
	public void updateKlijenta(Klijent k) {
		
		session.update(k);
		t.commit();
		
	}
	
	public Klijent dajKlijenta(long id) {
		
		Klijent k = (Klijent)session.get(Klijent.class, id);
		
		if(k == null) {
		
			return null;
		}
		
		else {
			
			return k;
		}
	}
	
	public Klijent dajKlijenta(String JIB) {
	
		Query query = session.createQuery("from Klijent where jib = :tempJib");
		query.setParameter("tempJib", JIB);
		List<Klijent> temp=query.list();
		
		if(temp.size() == 0) {
			
			return null;
		}
		
		return (Klijent)temp.get(0);
	
	}
	
	public boolean postojiKlijent(String JIB) {
		
		Query query = session.createQuery("from Klijent where jib = :tempJib");
		query.setParameter("tempJib", JIB);
		
		if(query.list().size()==0) {
	
			return false;
		}
		
		else {
	
			return true;
		}
	}

	public List<Klijent> dajSveKlijente()
	{
		List<Klijent> temp=new ArrayList<Klijent>();
		temp=session.createCriteria(Klijent.class).list();
		if(temp.size()==0) {
			return null;
		}
		return temp;
	}
	public boolean postojiKlijent(long id) {
		
		Klijent u = (Klijent)session.get(Klijent.class, id);
		
		if(u == null) {

			return false;
		}
		
		else {

			return true;
		}
	}
	
	public List<Klijent> vratiSveKlijente() {
		
		List<Klijent> lista= session.createCriteria(Klijent.class).list();

		return lista;
	}

	public void brisiKlijenta(Klijent k) {

			session.delete(k);
			t.commit();
		}
	
	}
