package de.limago.schweine.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.limago.schweine.dtos.PersonDTO;
import de.limago.schweine.service.PersonService;
import de.limago.schweine.service.PersonServiceException;
import de.limago.schweine.web.PersonMapper;

@RequestScoped
@Path("/personen")
public class PersonController {

	@Inject private PersonMapper mapper;
	@Inject private PersonService service;
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/speichern")
	public Response speichern(PersonDTO personDTO) {
		Response.ResponseBuilder builder = null;
		try {
			if(service.speichern(mapper.convert(personDTO))) {
				builder = Response.status(Status.CREATED);
			} else {
				builder = Response.ok();
			}
		} catch (PersonServiceException e) {
			// loggen
			e.printStackTrace();
			builder = Response.status(Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/person/{id}")
	public Response getSinglePerson(@PathParam("id") String id) {
		Response.ResponseBuilder builder = null;
		try {
			builder = service.findeMitId(id).map(mapper::convert).map(Response::ok).orElse(Response.status(Status.NOT_FOUND));
				
		} catch (PersonServiceException e) {
			builder = Response.status(Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();
	}
}
