package de.limago.schweine.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import de.limago.schweine.model.SchweinEntity;

@Local
public interface SchweinRepository {
	
	Optional<SchweinEntity> findById(String id);
	List<SchweinEntity> findAll();
	List<SchweinEntity> findByName(String name);
	boolean saveOrUpdate(SchweinEntity schweinEntity);
	boolean delete(SchweinEntity schweinEntity);
	boolean delete(String id);
}
