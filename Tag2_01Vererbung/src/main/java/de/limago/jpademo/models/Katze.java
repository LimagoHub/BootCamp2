package de.limago.jpademo.models;

import javax.persistence.Entity;

@Entity
public class Katze extends Tier{
	
	private int anzahMauese=5;

	public int getAnzahMauese() {
		return anzahMauese;
	}

	public void setAnzahMauese(int anzahMauese) {
		this.anzahMauese = anzahMauese;
	}
	
	

}
