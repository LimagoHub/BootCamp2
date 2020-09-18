package de.gothaer.langermann.services;

import java.util.List;

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

	@EJB
	private PersonRepository repo;

	public void speichern(Person person) {
		if(person.getVorname().equals("Attila")) return;
		repo.save(person);
		
	}

	public List<Person> gibMichAlle() {
		
		return repo.findAll();
	}

}
