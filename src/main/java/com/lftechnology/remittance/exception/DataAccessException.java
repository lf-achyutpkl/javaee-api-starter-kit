package com.lftechnology.remittance.exception;

import javax.persistence.PersistenceException;

/**
 * Wrapper exception class for {@link PersistenceException}
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = -4951239424466500973L;

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
