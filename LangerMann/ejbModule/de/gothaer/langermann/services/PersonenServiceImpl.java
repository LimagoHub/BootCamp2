package de.gothaer.langermann.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import de.gothaer.langermann.repositoies.PersonRepository;
import de.gothaer.langermann.repositoies.entities.Person;

/**
 * Session Bean implementation class PersonenServiceImpl
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonenServiceImpl implements PersonenService {

	@EJB // Dependency Injection
	private PersonRepository repo;
	
	public PersonenServiceImpl() {
		System.out.println("Constructor: " + repo);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Post Constructor: " + repo);
	}

	public void speichern(Person person) throws PersonenServiceException {
		try {
			if (person.getVorname().equals("Attila"))
				throw new PersonenServiceException("Antipath");
			repo.save(person);
		} catch (RuntimeException e) {
			throw new PersonenServiceException(e);
		}

	}

	public List<Person> gibMichAlle() throws PersonenServiceException {

		try {
			return repo.findAll();
		} catch (RuntimeException e) {
			throw new PersonenServiceException(e);
		}
	}

}
