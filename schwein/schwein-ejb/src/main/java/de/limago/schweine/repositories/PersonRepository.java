package de.limago.schweine.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import de.limago.schweine.model.PersonEntity;

@Local
public interface PersonRepository {
	
	Optional<PersonEntity> findById(String id);
	List<PersonEntity> findAll();
	List<PersonEntity> findByVorname(String vorname);
	List<PersonEntity> findByNachname(String nachname);
	List<PersonEntity> findByVornameAndNachname(String vorname, String nachname);
	boolean saveOrUpdate(PersonEntity entity);
	boolean delete(PersonEntity entity);
	boolean delete(String id);

}
