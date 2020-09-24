package de.limago.schweine.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.limago.schweine.model.SchweinEntity;
import de.limago.schweine.service.domainobjects.Schwein;

@Mapper(componentModel = "cdi")
public interface SchweinEntityMapper {
	
	Schwein convert(SchweinEntity entity);
	SchweinEntity convert(Schwein schwein);
	List<Schwein> convert(List<SchweinEntity> entities);
}
