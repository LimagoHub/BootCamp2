package de.gothaer.first.repositories;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.gothaer.first.model.Person;

@Stateless
public class PersonRepository {
	
	@Inject
	private Logger log;
	
	@Inject
	private EntityManager entityManager;
	
	public void save(Person person) {
		entityManager.persist(person);
		log.info("Person gespeichert");
	}
	
	public List<Person> findAll() {
		return entityManager.createQuery("from Person", Person.class).getResultList();
	}
}
