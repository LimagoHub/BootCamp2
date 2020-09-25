package de.limago.schweine.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Inject private Validator validator;
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/speichern")
	public Response speichern(PersonDTO personDTO) {
		Response.ResponseBuilder builder = null;
		try {
			validate(personDTO);
			if(service.speichern(mapper.convert(personDTO))) {
				builder = Response.status(Status.CREATED);
			} else {
				builder = Response.ok();
			}
		}catch (ConstraintViolationException e) {
			builder = createViolationResponse(e.getConstraintViolations());
		}
		
		catch (PersonServiceException e) {
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/person")
	public Response getPersonByVorname(@QueryParam("vorname") String vorname) {
		try {
			return Response.ok(mapper.convert(service.findeMitVorname(vorname))).build();
		} catch (PersonServiceException e) {
			return Response.serverError().build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/person")
	public Response getPersonByVornameAndNachname(@QueryParam("vorname") String vorname, @QueryParam("nachname") String nachname) {
		try {
			return Response.ok(mapper.convert(service.findeMitVornameUndNachname(vorname, nachname))).build();
		} catch (PersonServiceException e) {
			return Response.serverError().build();
		}
	}
	
	
	
	private void validate(PersonDTO toCheck) throws  ConstraintViolationException {
	        // Create a bean validator and check for issues.
	        Set<ConstraintViolation<PersonDTO>> violations = validator.validate(toCheck);

	        if (!violations.isEmpty()) {
	            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
	        }

	       
	    }
	 
	 private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
	       

	        Map<String, String> responseObj = new HashMap<>();

	        for (ConstraintViolation<?> violation : violations) {
	            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
	        }

	        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	    }
}
