package de.ejb;

import java.util.List;

import de.pojo.Person;

public interface IPersonenService {
	
	public static final String JNDI_NAME = "PersonenService/remote";
	
	
	public void bulkInsert(List<Person> liste) throws PersonenServiceException;
	public Person create(Person person)throws PersonenServiceException;
	public Person update(Person person)throws PersonenServiceException;
	public Person findByPk(int id)throws PersonenServiceException;
	public List<Person> findAll()throws PersonenServiceException;

}
