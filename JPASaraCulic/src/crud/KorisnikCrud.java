package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Korisnik;
import model.Poruka;
import utils.PersistenceUtil;

public class KorisnikCrud {
	
	public void insertKorisnik(Korisnik k) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(k);
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
	
	public boolean deleteKorisnik(Korisnik k) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		
		boolean rez = false;
		try {
			et = em.getTransaction();
			et.begin();
			
			k = em.merge(k);
			List<Poruka> poruke1 = k.getPorukas1();
			List<Poruka> poruke2 = k.getPorukas2();
			
			for (Poruka poruka : poruke1) {
				em.remove(poruka);
			}
			em.merge(k);
			
			for (Poruka poruka : poruke2) {
				em.remove(poruka);
			}
			em.merge(k);
			em.remove(k);
			
			em.flush();
			et.commit();
			rez = true;
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
		return rez;
	}
	
	public List<Poruka> porukeKojeJePoslaoKorisnik(Korisnik k){
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Poruka> poruke = null;
		Query q = em.createQuery("select p from Poruka p where p.korisnik1=:x");
		q.setParameter("x", k);
		poruke = q.getResultList();
		em.close();
		return poruke;
		
	}
	
	public List<Korisnik> listKorisnika() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Korisnik> korisnici = em.createQuery("select k from Korisnik k").getResultList();
		em.close();
		return korisnici;
	}

}
