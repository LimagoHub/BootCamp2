package de.limago.schweine.mapper;

import de.limago.schweine.model.SchweinEntity;
import de.limago.schweine.model.SchweinEntity.SchweinEntityBuilder;
import de.limago.schweine.service.domainobjects.Schwein;
import de.limago.schweine.service.domainobjects.Schwein.SchweinBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-23T20:45:51+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@ApplicationScoped
public class SchweinEntityMapperImpl implements SchweinEntityMapper {

    @Override
    public Schwein convert(SchweinEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SchweinBuilder schwein = Schwein.builder();

        schwein.id( entity.getId() );
        schwein.name( entity.getName() );
        schwein.gewicht( entity.getGewicht() );

        return schwein.build();
    }

    @Override
    public SchweinEntity convert(Schwein schwein) {
        if ( schwein == null ) {
            return null;
        }

        SchweinEntityBuilder schweinEntity = SchweinEntity.builder();

        schweinEntity.id( schwein.getId() );
        schweinEntity.name( schwein.getName() );
        schweinEntity.gewicht( schwein.getGewicht() );

        return schweinEntity.build();
    }

    @Override
    public List<Schwein> convert(List<SchweinEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Schwein> list = new ArrayList<Schwein>( entities.size() );
        for ( SchweinEntity schweinEntity : entities ) {
            list.add( convert( schweinEntity ) );
        }

        return list;
    }
}
