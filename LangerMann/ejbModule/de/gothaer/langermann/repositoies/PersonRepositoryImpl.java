package de.gothaer.langermann.repositoies;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.gothaer.langermann.repositoies.entities.Person;

/**
 * Session Bean implementation class PersonRepositoryImpl
 */
@Stateless(mappedName = "PersonRepository")
public class PersonRepositoryImpl implements PersonRepository {
	
	@PersistenceContext(name="gothaer")
	private EntityManager em;

	public void save(Person person) {
		em.persist(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		return em.createQuery("from Person").getResultList();
	}
	
	    

}
