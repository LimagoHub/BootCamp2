package de.limago.schweine.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.limago.schweine.model.PersonEntity;

/**
 * Session Bean implementation class PersonRepositoryImpl
 */
@Stateless
public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManager entityManager;

    @Inject
	public PersonRepositoryImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Optional<PersonEntity> findById(String id) {
		return Optional.ofNullable(entityManager.find(PersonEntity.class, id));
	}

	@Override
	public List<PersonEntity> findAll() {
		
		return entityManager.createNamedQuery("PersonEntity.findAll", PersonEntity.class).getResultList();
	}

	@Override
	public List<PersonEntity> findByVorname(String vorname) {
		TypedQuery<PersonEntity> query = entityManager.createNamedQuery("PersonEntity.findByVorname", PersonEntity.class);
		query.setParameter("vorname", vorname);
		return query.getResultList();
	}

	@Override
	public List<PersonEntity> findByNachname(String nachname) {
		TypedQuery<PersonEntity> query = entityManager.createNamedQuery("PersonEntity.findByNachname", PersonEntity.class);
		query.setParameter("nachname", nachname);
		return query.getResultList();
	}

	@Override
	public boolean saveOrUpdate(PersonEntity entity) {
		if(findById(entity.getId()).isPresent()) {
			entityManager.merge(entity);
			return false;
		}
		entityManager.persist(entity);	
		return true;
	}

	@Override
	public boolean delete(PersonEntity entity) {
		return delete(entity.getId());
	}

	@Override
	public boolean delete(String id) {
		PersonEntity toDelete = entityManager.find(PersonEntity.class, id);
		if(toDelete == null)
			return false;
		entityManager.remove(toDelete);
		return true;
	}
    
    

}
