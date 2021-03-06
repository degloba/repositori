package com.degloba.ioc.spring.sharedkernel.exceptions;

/**
 * @author degloba
 * 
 * @category Excepció que es produeix per algun dels proveidors/contenidors IoC (Spring, Guice, etc.).
 */
public class IocException extends RuntimeException {

	private static final long serialVersionUID = -2359843215972162510L;

	public IocException() {
	}

	public IocException(String message) {
		super(message);
	}

	public IocException(Throwable cause) {
		super(cause);
	}

	public IocException(String message, Throwable cause) {
		super(message, cause);
	}

}
