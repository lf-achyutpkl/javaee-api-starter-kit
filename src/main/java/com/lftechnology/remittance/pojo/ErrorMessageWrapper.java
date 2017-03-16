package com.lftechnology.remittance.pojo;

import java.util.List;

/**
 * Created by prkandel on 3/16/17.
 */
public class ErrorMessageWrapper {
    Integer status;

    String message;

    List<ErrorMessage> errors;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }
}
