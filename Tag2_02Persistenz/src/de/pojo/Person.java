package de.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="tblPersonen")
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7569742449908233246L;
	
	
	private int id, version=0;
	private String vorname, nachname;
	
	public Person() {
		this("John", "Doe");
	}
	
	

	@Version
	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}




	public Person(String vorname, String nachname) {
		setVorname(vorname);
		setNachname(nachname);
		setId(0);
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=30)
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Column(length=30, nullable=false)
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname="
				+ nachname + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	



}
