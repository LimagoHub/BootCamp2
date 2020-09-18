package de.gothaer.langermann.services;

import java.util.List;

import javax.ejb.Remote;

import de.gothaer.langermann.repositoies.entities.Person;

@Remote
public interface PersonenService {
	String JNDI_NAME = "PersonenServiceImpl/remote";
	void speichern(Person person);
	List<Person> gibMichAlle();
}
