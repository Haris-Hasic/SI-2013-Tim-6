package ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

public class HibernateUposlenik {
	
	public HibernateUposlenik() {
		
	}
	
	public void dodajUposlenika(Uposlenik u) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Long id = (Long)session.save(u);
		t.commit();
		
		session.close();
	}
	
	public void updateUposlenika(Uposlenik u) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.update(u);
		t.commit();
		
		session.close();
	}
	
	public void updateUposlenikBezSifre(Uposlenik uposlenik)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("update Uposlenik set"
				+ " ime = :tIme ,"
				+ " prezime = :tPrezime ,"
				+ " jib = :tJib ,"
				+ " adresa = :tAdresa ,"
				+ " mjesto = :tMjesto ,"
				+ " telefon = :tTelefon ,"
				+ " email = :tEmail ,"
				+ " tip = :tTip ,"
				+ " userName = :tUsername"
				+ " where id = :tId ");
			query.setParameter("tIme",uposlenik.getIme());
			query.setParameter("tPrezime",uposlenik.getPrezime() );
			query.setParameter("tJib",uposlenik.getJmbg() );
			query.setParameter("tAdresa",uposlenik.getAdresa() );
			query.setParameter("tMjesto",uposlenik.getMjesto() );
			query.setParameter("tTelefon",uposlenik.getTelefon() );
			query.setParameter("tEmail",uposlenik.getEmail() );
			query.setParameter("tTip",uposlenik.getTip() );
			query.setParameter("tUsername",uposlenik.getUserName() );
			query.setParameter("tId",uposlenik.getId() );
			
			int result = query.executeUpdate();
			t.commit();
			session.close();
			
	}
	public Uposlenik dajUposlenika(long id) {
		
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
	
public Uposlenik dajUposlenika(String userName) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from Uposlenik where userName = :uName");
		query.setParameter("uName", userName);
		List<Uposlenik> temp=query.list();
		
		if(temp.size() == 0) {
			
			session.close();
			return null;
		}

		session.close();
		return (Uposlenik)temp.get(0);
	
	}

public Uposlenik dajUposlenikaJMBG(String jmbg) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Uposlenik where jib = :jmbg");
	query.setParameter("jmbg", jmbg);
	List<Uposlenik> temp=query.list();
	
	if(temp.size() == 0) {
		
		session.close();
		return null;
	}

	session.close();
	return (Uposlenik)temp.get(0);

}

public boolean postojiUposlenik(String userName) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Uposlenik where userName = :uName");
	query.setParameter("uName", userName);
	
	if(query.list().size()==0) {
		
		session.close();
		return false;
	}
	
	else {
		
		session.close();
		return true;
	}
}

public boolean postojiPassword(String pass) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Uposlenik where password = :password");
	query.setParameter("password", pass);
	
	if(query.list().size()==0) {
		
		session.close();
		return false;
	}
	
	else {
		
		session.close();
		return true;
	}
}


public boolean postojiUposlenikJMBG(String jmbg) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	Query query = session.createQuery("from Uposlenik where jmbg = :jmbg");
	query.setParameter("jmbg", jmbg);
	
	if(query.list().size() == 0) {
		
		session.close();
		return false;
	}
	
	else {
		
		session.close();
		return true;
	}
}


	public List<Uposlenik> dajSveUposlenike()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Uposlenik> temp=new ArrayList<Uposlenik>();
		Transaction t = session.beginTransaction();
		
		temp=session.createCriteria(Uposlenik.class).list();
		if(temp.size()==0) {
			
			session.close();
			return null;
		}
		session.close();
		return temp;
	}
	
	
	public boolean postojiUposlenik(long id) {
		
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
	
	public List<Uposlenik> vratiSveUposlenike() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		List<Uposlenik> lista= session.createCriteria(Uposlenik.class).list();
		
		session.close();
		return lista;
	}

	public void brisiUposlenika(Uposlenik u) {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Transaction t = session.beginTransaction();
			session.delete(u);
			t.commit();
			session.close();
		}
	
	}
