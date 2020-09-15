package de.limago.jpademo.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;


//JPA
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@TableGenerator(name="seqtab", initialValue = 0, allocationSize = 10)
public abstract class Tier {
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "seqtab")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30)
	private String name;
	
	
	public Tier() {
		this("Fiffi");
	}
	
	
	
	public Tier(String name) {
		this.id = 0;
		this.name = name;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Tier [id=" + id + ", name=" + name + "]";
	}
	

}
