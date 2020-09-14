package de.limago.jpademo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_personen")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30)
	private String vorname;
	@Column(length = 30, nullable = false)
	private String nachname;
//	@Column(name="age")
//	private int alter = 18;
	
	public Person() {
		this("John","Doe");
	}
	
	public Person(String vorname, String nachname) {
		this.id = 0;
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
