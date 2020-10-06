package br.com.ecomerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5415031645433267494L;

	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
