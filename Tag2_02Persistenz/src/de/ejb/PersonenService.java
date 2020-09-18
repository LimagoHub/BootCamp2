package de.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.pojo.Person;


@Stateless
@Remote(IPersonenService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonenService implements IPersonenService {
	
	@PersistenceContext(name="herbert")
	private EntityManager em;

	
	// Wärend der Funktionsausführung läuft eine transaktion, nach persist ist person attached
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Person create(Person person) throws PersonenServiceException {
		try {
			em.persist(person);
			
			return person;
		} catch (RuntimeException e) {
			throw new PersonenServiceException(e);
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Person update(Person person) throws PersonenServiceException {
		Person attachedPerson = em.merge(person);
		
		
		
		return attachedPerson;
	}



	@Override
	public Person findByPk(int id) throws PersonenServiceException {
		// TODO Auto-generated method stub
		return em.find(Person.class, id);
	}
	
	@Override
	public List<Person> findAll() throws PersonenServiceException {
		List<Person> retval;
		Query query = em.createQuery("from Person");
	
		query.setMaxResults(100);
		retval = query.getResultList();
		
		return retval;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void bulkInsert(List<Person> liste) throws PersonenServiceException {
		try {
			for (Person person : liste) {
				create(person);
			}
		} catch (Exception e) {
			throw new PersonenServiceException("Häh?", e);
		}
		
	}

}
