package br.com.aula.enums;

public enum ErrorCode {

	BAD_REQUEST(400), SERVER_ERROR(500), NOT_FOUND(404);

	private int code;

	private ErrorCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
