package com.dl.base.exception;

/**
 * 公用的Exception.
 * 继承自RuntimeException,会触发Spring的事务管理引起事务回退.
 */
public class DLUtilException extends RuntimeException {
	public DLUtilException() {
		super();
	}

	public DLUtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public DLUtilException(String message) {
		super(message);
	}

	public DLUtilException(Throwable cause) {
		super(cause);
	}
}
