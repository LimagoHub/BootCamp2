package de.limago.schweine.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import de.limago.schweine.service.domainobjects.Person;

@Local
public interface PersonService {
	Optional<Person> findeMitId(String id) throws PersonServiceException;
	List<Person> findeAll() throws PersonServiceException;
	List<Person> findeMitVorname(String vorname) throws PersonServiceException;
	List<Person> findeMitNachname(String nachname) throws PersonServiceException;
	boolean speichern(Person entity) throws PersonServiceException;
	boolean loeschen(Person entity) throws PersonServiceException;
	boolean loeschen(String id) throws PersonServiceException;
}
