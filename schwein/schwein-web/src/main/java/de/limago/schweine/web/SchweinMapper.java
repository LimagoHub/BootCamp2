package de.limago.schweine.web;
 
import java.util.List;

import org.mapstruct.Mapper;

import de.limago.schweine.dtos.SchweinDTO;
import de.limago.schweine.service.domainobjects.Schwein;

@Mapper(componentModel = "cdi")
public interface SchweinMapper {

	SchweinDTO convert(Schwein schwein);
	Schwein convert(SchweinDTO dto);
	List<SchweinDTO> convert(List<Schwein> schweineliste);
}
