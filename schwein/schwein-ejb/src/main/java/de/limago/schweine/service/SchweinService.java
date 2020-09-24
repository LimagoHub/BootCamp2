package de.limago.schweine.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import de.limago.schweine.service.domainobjects.Schwein;

@Local
public interface SchweinService {
	
	Optional<Schwein> findeSchweinMitPS(String ps) throws SchweineServiceException;
	List<Schwein> findeAlleSchweine() throws SchweineServiceException;
	List<Schwein> findeMitName(String name) throws SchweineServiceException;
	boolean speichereSchwein(Schwein schwein)  throws SchweineServiceException;;
	boolean loesche(Schwein schwein)  throws SchweineServiceException;;
	boolean loesche(String ps)  throws SchweineServiceException;;
	void fuettere(Schwein schwein)  throws SchweineServiceException;;
}
