package com.lftechnology.remittance.exception.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lftechnology.remittance.pojo.ErrorMessage;
import com.lftechnology.remittance.pojo.ErrorMessageWrapper;

/**
 * Created by prkandel on 3/16/17.
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        ErrorMessageWrapper errorMessageWrapper = new ErrorMessageWrapper();
        errorMessageWrapper.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
        errorMessageWrapper.setMessage("Validation Errors");

        List<ErrorMessage> errorMessages = new ArrayList<>();

        for (ConstraintViolation constraintViolation : exception.getConstraintViolations()) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage(constraintViolation.getMessage());
            errorMessages.add(errorMessage);
        }
        errorMessageWrapper.setErrors(errorMessages);
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessageWrapper).type(MediaType.APPLICATION_JSON).build();
    }
}
