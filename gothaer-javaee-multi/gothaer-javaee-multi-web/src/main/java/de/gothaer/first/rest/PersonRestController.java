package de.gothaer.first.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import de.gothaer.first.model.Person;
import de.gothaer.first.service.PersonService;
import de.gothaer.first.service.PersonenServiceException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@RequestScoped
@Path("/personen")
public class PersonRestController {

	@Inject
	private PersonService personService;
	
	@PUT
	@Path("/speichern")
	@Consumes("application/json")
	public Response save(Person person) {
		try {
			personService.speichern(person);
			return Response.status(Status.CREATED).build();
		} catch (PersonenServiceException e) {
			return Response.serverError().build();
		}
	}

}
