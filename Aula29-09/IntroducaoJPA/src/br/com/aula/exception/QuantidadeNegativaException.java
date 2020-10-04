package br.com.aula.exception;

public class QuantidadeNegativaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public QuantidadeNegativaException(String mensagem) {
		super(mensagem);
	}

}
