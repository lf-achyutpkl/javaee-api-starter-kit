package com.lftechnology.remittance.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lftechnology.remittance.exception.ObjectNotFoundException;
import com.lftechnology.remittance.pojo.ErrorMessage;

/**
 * Exception mapper for {@link ObjectNotFoundException}
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 *
 */
@Provider
public class ObjectNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {

	@Override
	public Response toResponse(ObjectNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setCode(Response.Status.NOT_FOUND.getStatusCode());
		errorMessage.setMessage("No row with given identifier");
		return Response.status(Response.Status.NOT_FOUND).entity(errorMessage)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
