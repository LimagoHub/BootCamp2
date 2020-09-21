package de.gothaer.langermann.services;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class PersonenServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2280060360235668107L;

	public PersonenServiceException() {
		// TODO Auto-generated constructor stub
	}

	public PersonenServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PersonenServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PersonenServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PersonenServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
