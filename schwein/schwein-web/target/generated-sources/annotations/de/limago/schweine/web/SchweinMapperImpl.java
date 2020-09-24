package de.limago.schweine.web;

import de.limago.schweine.dtos.SchweinDTO;
import de.limago.schweine.dtos.SchweinDTO.SchweinDTOBuilder;
import de.limago.schweine.service.domainobjects.Schwein;
import de.limago.schweine.service.domainobjects.Schwein.SchweinBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-23T22:23:38+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@ApplicationScoped
public class SchweinMapperImpl implements SchweinMapper {

    @Override
    public SchweinDTO convert(Schwein schwein) {
        if ( schwein == null ) {
            return null;
        }

        SchweinDTOBuilder schweinDTO = SchweinDTO.builder();

        schweinDTO.id( schwein.getId() );
        schweinDTO.name( schwein.getName() );
        schweinDTO.gewicht( schwein.getGewicht() );

        return schweinDTO.build();
    }

    @Override
    public Schwein convert(SchweinDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SchweinBuilder schwein = Schwein.builder();

        schwein.id( dto.getId() );
        schwein.name( dto.getName() );
        schwein.gewicht( dto.getGewicht() );

        return schwein.build();
    }

    @Override
    public List<SchweinDTO> convert(List<Schwein> schweineliste) {
        if ( schweineliste == null ) {
            return null;
        }

        List<SchweinDTO> list = new ArrayList<SchweinDTO>( schweineliste.size() );
        for ( Schwein schwein : schweineliste ) {
            list.add( convert( schwein ) );
        }

        return list;
    }
}
