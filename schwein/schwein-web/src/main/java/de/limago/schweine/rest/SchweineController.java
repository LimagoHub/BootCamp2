package de.limago.schweine.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.limago.schweine.dtos.SchweinDTO;
import de.limago.schweine.service.SchweinService;
import de.limago.schweine.service.SchweineServiceException;
import de.limago.schweine.web.SchweinMapper;

@RequestScoped
@Path("/schweine")
public class SchweineController {

	@Inject
	private Logger log;
	@Inject
	private SchweinMapper mapper;
	@Inject
	private SchweinService service;
	@Inject
    private Validator validator;
	@Inject
	private HttpServletRequest request;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/schwein/{id}")
	public Response schweinById(@PathParam("id") String id) {
		Response.ResponseBuilder builder = null;
		
		try {
			builder =  service.findeSchweinMitPS(id)
					.map(mapper::convert)
					.map(Response::ok)
					.orElse(Response.status(Status.NOT_FOUND));
		} catch (SchweineServiceException e) {
			log.log(Level.SEVERE, "Fehler im Service", e);
			builder = Response.serverError();
		}
		//builder.header("location",URI.create(request.getRequestURL().toString()));
		return builder.build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/speichern")
	public Response speichern(SchweinDTO schwein) {
		Response.ResponseBuilder builder = null;
		try {
			validate(schwein);
			if(service.speichereSchwein(mapper.convert(schwein)))
				builder = Response.status(Status.CREATED);
			else
				builder = Response.ok();
		} catch (ConstraintViolationException e) {
			log.log(Level.SEVERE,"Fehler beim Validieren",e);
			builder = createViolationResponse(e.getConstraintViolations());
		} catch (SchweineServiceException e) {
			log.log(Level.SEVERE,"Fehler im Service",e);
			builder = Response.status(Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();
	}
	
	 private void validate(SchweinDTO schwein) throws  ConstraintViolationException {
	        // Create a bean validator and check for issues.
	        Set<ConstraintViolation<SchweinDTO>> violations = validator.validate(schwein);

	        if (!violations.isEmpty()) {
	            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
	        }

	       
	    }
	 
	 private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
	        log.fine("Validation completed. violations found: " + violations.size());

	        Map<String, String> responseObj = new HashMap<>();

	        for (ConstraintViolation<?> violation : violations) {
	            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
	        }

	        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	    }
}
