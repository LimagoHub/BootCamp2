package de.limago.schweine.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import de.limago.schweine.mapper.SchweinEntityMapper;
import de.limago.schweine.repositories.SchweinRepository;
import de.limago.schweine.service.domainobjects.Schwein;

/**
 * Session Bean implementation class SchweinServiceImpl
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SchweinServiceImpl implements SchweinService {

	private final Logger log;
    private final SchweinEntityMapper mapper;
    private final SchweinRepository repo;
    
    @Inject
	public SchweinServiceImpl(final Logger log, final SchweinEntityMapper mapper, final SchweinRepository repo) {
		this.log = log;
		this.mapper = mapper;
		this.repo = repo;
	}

	@Override
	public Optional<Schwein> findeSchweinMitPS(String ps) throws SchweineServiceException {
		try {
			log.info("Suche Schwein");
			return repo.findById(ps).map(mapper::convert);
		} catch (RuntimeException e) {
			log.log(Level.SEVERE,"Fehler beim lesen des Schweins", e);
			throw new SchweineServiceException(e);
		}
	}

	@Override
	public List<Schwein> findeAlleSchweine() throws SchweineServiceException {
		return mapper.convert(repo.findAll());
	}

	@Override
	public List<Schwein> findeMitName(String name) throws SchweineServiceException {
		return mapper.convert(repo.findByName(name));
	}

	@Override
	public boolean speichereSchwein(Schwein schwein) throws SchweineServiceException {
		return repo.saveOrUpdate(mapper.convert(schwein));
	}

	@Override
	public boolean loesche(Schwein schwein) throws SchweineServiceException {
		return loesche(schwein);
	}

	@Override
	public boolean loesche(String ps) throws SchweineServiceException {
		
		return repo.delete(ps);
	}

	@Override
	public void fuettere(Schwein schwein) throws SchweineServiceException {
		Schwein piggy =findeSchweinMitPS(schwein.getId()).orElseThrow(()->new SchweineServiceException("Kein Schwein"));
		piggy.fressen();
		speichereSchwein(piggy);
		
	}
    
    

}
