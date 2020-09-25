package de.limago.schweine.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Qualifier;

import de.limago.schweine.annotations.AntipathenQualifier;
import de.limago.schweine.mapper.PersonEntityMapper;
import de.limago.schweine.repositories.PersonRepository;
import de.limago.schweine.service.domainobjects.Person;

/**
 * Session Bean implementation class PersonServiceImpl
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonServiceImpl implements PersonService {
	
	
	private final PersonEntityMapper mapper;
	private final PersonRepository repo;
	
	private final List<String> antipathen;

	@Inject
	public PersonServiceImpl(final PersonEntityMapper mapper, final PersonRepository repo,  @AntipathenQualifier final List<String> antipathen) {
		this.mapper = mapper;
		this.repo = repo;
		this.antipathen = antipathen;
	}


	@Override
	public Optional<Person> findeMitId(String id) throws PersonServiceException {
		
		return repo.findById(id).map(mapper::convert);
	}
	
//	private Person wandele(PersonEntity e) {
//		return mapper.convert(e);
//	}


	@Override
	public List<Person> findeAll() throws PersonServiceException {
		
		return mapper.convert(repo.findAll());
	}


	@Override
	public List<Person> findeMitVorname(String vorname) throws PersonServiceException {
		
		return mapper.convert(repo.findByVorname(vorname));
	}


	@Override
	public List<Person> findeMitNachname(String nachname) throws PersonServiceException {
		return mapper.convert(repo.findByNachname(nachname));
	}


	@Override
	public boolean speichern(Person person) throws PersonServiceException {
		if(antipathen.contains(person.getVorname()))
			throw new PersonServiceException("Antipath");
		return repo.saveOrUpdate(mapper.convert(person));
	}


	@Override
	public boolean loeschen(Person person) throws PersonServiceException {
		
		return loeschen(person.getId());
	}


	@Override
	public boolean loeschen(String id) throws PersonServiceException {
		
		return repo.delete(id);
	}


	@Override
	public List<Person> findeMitVornameUndNachname(String vorname, String nachname) throws PersonServiceException {
		return mapper.convert(repo.findByVornameAndNachname(vorname, nachname));
	}

	
   

}
