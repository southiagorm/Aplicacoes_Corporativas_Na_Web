package br.com.aula.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6738941103923506187L;

	public ServiceException(String mensagem) {
		super(mensagem);
	}
}
