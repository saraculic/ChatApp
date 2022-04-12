package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int korisnikId;

	private String korisnikIme;

	private String korisnikPrezime;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik1")
	private List<Poruka> porukas1;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik2")
	private List<Poruka> porukas2;

	public Korisnik() {
		this.porukas1 = new ArrayList<Poruka>();
		this.porukas2 = new ArrayList<Poruka>();
	}
	
	public Korisnik(String korisnikIme, String korisnikPrezime) {
		this();
		this.korisnikIme = korisnikIme;
		this.korisnikPrezime = korisnikPrezime;
	}

	public int getKorisnikId() {
		return this.korisnikId;
	}

	public void setKorisnikId(int korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getKorisnikIme() {
		return this.korisnikIme;
	}

	public void setKorisnikIme(String korisnikIme) {
		this.korisnikIme = korisnikIme;
	}

	public String getKorisnikPrezime() {
		return this.korisnikPrezime;
	}

	public void setKorisnikPrezime(String korisnikPrezime) {
		this.korisnikPrezime = korisnikPrezime;
	}

	
	public List<Poruka> getPorukas1() {
		return this.porukas1;
	}

	public void setPorukas1(List<Poruka> porukas1) {
		this.porukas1 = porukas1;
	}

	public Poruka addPorukas1(Poruka porukas1) {
		getPorukas1().add(porukas1);
		porukas1.setKorisnik1(this);

		return porukas1;
	}

	public Poruka removePorukas1(Poruka porukas1) {
		getPorukas1().remove(porukas1);
		porukas1.setKorisnik1(null);

		return porukas1;
	}

	public List<Poruka> getPorukas2() {
		return this.porukas2;
	}

	public void setPorukas2(List<Poruka> porukas2) {
		this.porukas2 = porukas2;
	}

	public Poruka addPorukas2(Poruka porukas2) {
		getPorukas2().add(porukas2);
		porukas2.setKorisnik2(this);

		return porukas2;
	}

	public Poruka removePorukas2(Poruka porukas2) {
		getPorukas2().remove(porukas2);
		porukas2.setKorisnik2(null);

		return porukas2;
	}

	@Override
	public String toString() {
		return korisnikIme + " " + korisnikPrezime;
	}
	
	

}