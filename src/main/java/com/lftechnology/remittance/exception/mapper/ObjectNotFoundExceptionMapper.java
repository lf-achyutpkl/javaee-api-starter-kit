package com.lftechnology.remittance.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lftechnology.remittance.exception.ObjectNotFoundException;

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
		return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage())
				.type(MediaType.APPLICATION_JSON).build();
	}
}
