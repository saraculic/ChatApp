package main;

import crud.KorisnikCrud;
import model.Korisnik;

public class GlavniProgram {

	public static void main(String[] args) {
	
		KorisnikCrud kc = new KorisnikCrud();
		Korisnik k = new Korisnik("Nikola", "Mirkovic");
		kc.insertKorisnik(k);
		
		System.exit(0);

	}

}
