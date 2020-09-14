package de.dbdemo;

import java.util.List;

public interface PersonRepository {
	
	// Crud
	// Create Read Update Delete
	
	void save (Person person);
	void update(Person person);
	void delete(Person person);
	void delete(int primaryKey);
	
	Person findByPrimaryKey(int pk);
	List<Person> findAll();
	List<Person> findByLastName(String lastname);
	List<Person> findByExample(Person example);

}
