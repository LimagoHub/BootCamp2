package de.limago.schweine.web;

import java.util.List;

import org.mapstruct.Mapper;

import de.limago.schweine.dtos.PersonDTO;
import de.limago.schweine.service.domainobjects.Person;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

	PersonDTO convert(Person person);
	Person convert(PersonDTO personDTO);
	List<PersonDTO> convert(List<Person> personen);
}
