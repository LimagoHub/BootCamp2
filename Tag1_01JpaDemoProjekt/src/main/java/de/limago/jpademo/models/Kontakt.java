package de.limago.jpademo.models;

import javax.persistence.Embeddable;

@Embeddable
public class Kontakt {
	
	private String kontaktArt;
	private String kontaktWert;
	
	public Kontakt() {
		this("Telefon","");
	}

	public Kontakt(String kontaktArt, String kontaktWert) {
		super();
		this.kontaktArt = kontaktArt;
		this.kontaktWert = kontaktWert;
	}

	public String getKontaktArt() {
		return kontaktArt;
	}

	public void setKontaktArt(String kontaktArt) {
		this.kontaktArt = kontaktArt;
	}

	public String getKontaktWert() {
		return kontaktWert;
	}

	public void setKontaktWert(String kontaktWert) {
		this.kontaktWert = kontaktWert;
	}

	@Override
	public String toString() {
		return "Kontakt [kontaktArt=" + kontaktArt + ", kontaktWert=" + kontaktWert + "]";
	}
	
	

}
