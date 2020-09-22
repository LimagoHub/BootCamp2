package de.gothaer.first.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblpersonen")
public class Person {
	
	@Id
	private String id;
	
	@Column(length = 30)
	private String vorname;
	
	@Column(length = 30)
	private String nachname;
	
	
	public Person() {
		this("","");
	}
	public Person(String vorname, String nachname) {
		this.id = null;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
	

}
