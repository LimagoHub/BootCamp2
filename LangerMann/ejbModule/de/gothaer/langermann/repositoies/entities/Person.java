package de.gothaer.langermann.repositoies.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_ejb_personen")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 754113073235219391L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	private String vorname;
	private String nachname;
	
	public Person() {
		this("John","Doe");
	}
	public Person(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + "]";
	}
	
	

}
