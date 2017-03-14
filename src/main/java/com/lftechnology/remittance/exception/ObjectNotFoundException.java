package com.lftechnology.remittance.exception;

/**
 * Exception class for object not found.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4446398909832697168L;

	public ObjectNotFoundException() {
		super("No row with the given identifier.");
	}

	public ObjectNotFoundException(String messsage) {
		super(messsage);
	}

	public ObjectNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
