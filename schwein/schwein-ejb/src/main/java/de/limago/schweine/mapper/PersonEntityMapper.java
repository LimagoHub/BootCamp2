package de.limago.schweine.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.limago.schweine.model.PersonEntity;
import de.limago.schweine.service.domainobjects.Person;

@Mapper(componentModel = "cdi")
public interface PersonEntityMapper {
	
	PersonEntity convert(Person person);
	Person convert(PersonEntity personEntity);
	List<Person> convert(List<PersonEntity> entities);

}
