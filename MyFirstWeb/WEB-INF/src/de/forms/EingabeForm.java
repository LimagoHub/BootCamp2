package de.forms;


// Model
public class EingabeForm {
	
	private String name;

	public EingabeForm() {
		this("Fritz");
	}
	
	public EingabeForm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
