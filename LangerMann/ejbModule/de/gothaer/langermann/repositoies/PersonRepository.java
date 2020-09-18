package de.gothaer.langermann.repositoies;

import java.util.List;

import javax.ejb.Local;

import de.gothaer.langermann.repositoies.entities.Person;

@Local
public interface PersonRepository {
	
	void save(Person person);
	List<Person> findAll();

}
