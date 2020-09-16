package de.limago.jpademo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


//JPA
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@TableGenerator(name="seqtab", initialValue = 0, allocationSize = 10)
public abstract class Tier extends BaseEntity{

	@Column(length = 30)
	private String name;
	
	
	public Tier() {
		this("Fiffi");
	}
	
	
	
	public Tier(String name) {
		
		this.name = name;
	}



	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Tier [name=" + name + ", toString()=" + super.toString() + "]";
	}
	

}
