package com.lftechnology.remittance.exception.mapper;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.lftechnology.remittance.exception.DataAccessException;
import com.lftechnology.remittance.pojo.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by prkandel on 3/16/17.
 */
@Provider
public class UnrecognizedPropertyMapper implements ExceptionMapper<UnrecognizedPropertyException> {

    @Override
    public Response toResponse(UnrecognizedPropertyException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(Response.Status.BAD_REQUEST.getStatusCode());
        errorMessage.setMessage("Unrecognized Field : "+exception.getPropertyName());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage)
                .type(MediaType.APPLICATION_JSON).build();
    }
}
