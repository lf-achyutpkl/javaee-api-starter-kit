package com.lftechnology.remittance.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonParseException;
import com.lftechnology.remittance.pojo.ErrorMessage;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {

    @Override
    public Response toResponse(JsonParseException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Invalid request body format");

        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }
}
