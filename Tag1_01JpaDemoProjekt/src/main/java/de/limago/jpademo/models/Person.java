package de.limago.jpademo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "tbl_personen")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Version
//	private int version=0;
	
	@Version
	private int version;
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastupdate;
	//private LocalDateTime lastUpdate;
	
	@Column(length = 30)
	private String vorname;
	@Column(length = 30, nullable = false)
	private String nachname;
//	@Column(name="age")
//	private int alter = 18;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Kontakt> kontakte = new ArrayList<>();
	
	@Embedded
	private Adresse adresse = new Adresse();
	
	public Person() {
		this("John","Doe");
	}
	
	public Person(String vorname, String nachname) {
		this.id = 0;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	
	
	public List<Kontakt> getKontakte() {
		return kontakte;
	}

	public void setKontakte(List<Kontakt> kontakte) {
		this.kontakte = kontakte;
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
	
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", version=" + version + ", vorname=" + vorname + ", nachname=" + nachname
				+ ", adresse=" + adresse + "]";
	}

	
	
	
	

}
