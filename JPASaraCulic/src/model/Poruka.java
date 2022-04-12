package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the poruka database table.
 * 
 */
@Entity
@NamedQuery(name="Poruka.findAll", query="SELECT p FROM Poruka p")
public class Poruka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int porukaId;

	private String datum;

	private String tekst;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnikIdSalje")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnikIdPrima")
	private Korisnik korisnik2;

	public Poruka() {
	}

	
	
	public int getPorukaId() {
		return this.porukaId;
	}

	public void setPorukaId(int porukaId) {
		this.porukaId = porukaId;
	}

	public String getDatum() {
		return this.datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Korisnik getKorisnik1() {
		return this.korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return this.korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}

	@Override
	public String toString() {
		return "Poruka [datum=" + datum + ", tekst=" + tekst + "]";
	}
	
	

}