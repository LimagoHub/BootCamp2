package de.limago.jpademo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Adresse {
	
	@Column(length = 5)
	private String plz;
	@Column(length = 30)
	private String ort;
	@Column(length = 30)
	private String strasse;
	
	public Adresse() {
		this("","","");
	}
	

	public Adresse(String plz, String ort, String strasse) {
		super();
		this.plz = plz;
		this.ort = ort;
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	@Override
	public String toString() {
		return "Adresse [plz=" + plz + ", ort=" + ort + ", strasse=" + strasse + "]";
	}
	
	

}
