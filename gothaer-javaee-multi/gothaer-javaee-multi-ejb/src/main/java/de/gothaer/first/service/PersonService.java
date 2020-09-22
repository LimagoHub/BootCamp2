package de.gothaer.first.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import de.gothaer.first.model.Person;
import de.gothaer.first.repositories.PersonRepository;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonService {

	@Inject
	private PersonRepository repo;
	
	public void speichern(Person person) throws  PersonenServiceException{
		repo.save(person);
	}
}
