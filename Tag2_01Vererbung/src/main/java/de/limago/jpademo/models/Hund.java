package de.limago.jpademo.models;

import javax.persistence.Entity;

@Entity
public class Hund extends Tier{

	private int anzahlKnochen = 3;

	public int getAnzahlKnochen() {
		return anzahlKnochen;
	}

	public void setAnzahlKnochen(int anzahlKnochen) {
		this.anzahlKnochen = anzahlKnochen;
	}
	
	
}
