package com.dl.base.exception;

/**
 * 公用的Exception.
 * 继承自RuntimeException,会触发Spring的事务管理引起事务回退.
 */
public class DLServiceException extends RuntimeException {
	public DLServiceException() {
		super();
	}

	public DLServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DLServiceException(String message) {
		super(message);
	}

	public DLServiceException(Throwable cause) {
		super(cause);
	}
}
