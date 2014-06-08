package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateUredjaj {
	
	public HibernateUredjaj() {
		
	}
	
	public void dodajUredjaj(Uredjaj u) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Long id = (Long)session.save(u);
		t.commit();
		
		session.close();
	}
	
	public void updateUredjaj(Uredjaj u) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(u);
		t.commit();
		
		session.close();
	}
	
	
	public Uredjaj dajUredjaj(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Uredjaj u = (Uredjaj)session.get(Uredjaj.class, id);
		
		if(u == null) {
			
			session.close();
			return new Uredjaj();
		}
		
		else {
			
			session.close();
			return u;
		}
	}
	
public Uredjaj dajUredjaj(String ibfu) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from Uredjaj where ibfu = :tIbfu");
		query.setParameter("tIbfu", ibfu);
		List<Uredjaj> temp=query.list();
		
		if(temp.size() == 0) {
			
			session.close();
			return new Uredjaj();
		}

		session.close();
		return (Uredjaj)temp.get(0);
	
	}
	
	public  List<Uredjaj> dajSveUredjaje(Klijent k) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Uredjaj where klijent = :kId");
	query.setParameter("kId", k);
	List<Uredjaj> temp=query.list();
	
	if(temp.size() == 0) {
		
		session.close();
		return new ArrayList<Uredjaj>();
	}

	session.close();
	return temp ;

}
	
public boolean postojiUredjaj(String ibfu) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Uredjaj where ibfu = :tIbfu");
	query.setParameter("tIbfu", ibfu);
	
	if(query.list().size()==0) {
		
		session.close();
		return false;
	}
	
	else {
		
		session.close();
		return true;
	}
}

	public List<Uredjaj> dajSveUredjaje()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Uredjaj> temp=new ArrayList<Uredjaj>();
		Transaction t = session.beginTransaction();
		
		temp=session.createCriteria(Uredjaj.class).list();
		if(temp.size()==0) {
			
			session.close();
			return new ArrayList<Uredjaj>();
		}
		session.close();
		return temp;
	}
	public boolean postojiUredjaj(long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Uredjaj u = (Uredjaj)session.get(Uredjaj.class, id);
		
		if(u == null) {
			
			session.close();
			return false;
		}
		
		else {
			
			session.close();
			return true;
		}
	}
	
	public List<Uredjaj> vratiSveUredjaje() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		List<Uredjaj> lista= session.createCriteria(Uredjaj.class).list();
		if(lista==null)
		{
			return new ArrayList<Uredjaj>();
		}
		session.close();
		return lista;
	}

	public void brisiUredjaj(Uredjaj u) {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Transaction t = session.beginTransaction();
			session.delete(u);
			t.commit();
			session.close();
		}
	
	}
