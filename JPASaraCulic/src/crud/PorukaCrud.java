package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Korisnik;
import model.Poruka;
import utils.PersistenceUtil;

public class PorukaCrud {
	
	public void insertPoruka(Korisnik k1, Korisnik k2, String datum, String tekst) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			k1 = em.merge(k1);
			k2 = em.merge(k2);
			Poruka p = new Poruka();
			p.setKorisnik1(k1);
			p.setKorisnik2(k2);
			p.setDatum(datum);
			p.setTekst(tekst);
			em.persist(p);
			
			em.flush();
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(et != null) {
				et.rollback();
			}
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
	}

}
