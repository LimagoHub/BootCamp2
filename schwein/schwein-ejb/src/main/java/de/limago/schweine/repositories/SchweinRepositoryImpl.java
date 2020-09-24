package de.limago.schweine.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.limago.schweine.model.SchweinEntity;

/**
 * Session Bean implementation class SchweinRepositoryImpl
 */
@Stateless
public class SchweinRepositoryImpl implements SchweinRepository {

	private final EntityManager entityManager;
	
	
	@Inject
	public SchweinRepositoryImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Optional<SchweinEntity> findById(String id) {
		return Optional.ofNullable(entityManager.find(SchweinEntity.class, id));
	}

	@Override
	public List<SchweinEntity> findAll() {
		return entityManager.createNamedQuery("SchweinEntity.findAll",SchweinEntity.class).getResultList();
	}

	@Override
	public List<SchweinEntity> findByName(String name) {
		TypedQuery<SchweinEntity> query = entityManager.createNamedQuery("SchweinEntity.findByName", SchweinEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public boolean saveOrUpdate(SchweinEntity schweinEntity) {
		if(findById(schweinEntity.getId()).isPresent()) {
			entityManager.merge(schweinEntity);
			return false;
		}
		entityManager.persist(schweinEntity);
		return true;
	}

	@Override
	public boolean delete(SchweinEntity schweinEntity) {
		return delete(schweinEntity);
	}

	@Override
	public boolean delete(String id) {
		SchweinEntity schweinEntity = entityManager.find(SchweinEntity.class, id);
		if(schweinEntity == null)
			return false;
		entityManager.remove(schweinEntity);
		return true;
	}

    

}
