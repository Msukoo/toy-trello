package com.toy.trelloapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BaseException extends ResponseStatusException {
	private final String errorCode;
	private final String traceId;
	private String rootCauseName;
	private String rootCauseMessage;

	public BaseException(HttpStatus status, String errorCode, String traceId) {
		this(status, (String)null, errorCode, traceId, (Throwable)null);
	}

	public BaseException(HttpStatus status, String errorCode, String traceId, Throwable cause) {
		this(status, (String)null, errorCode, traceId, cause);
	}

	public BaseException(HttpStatus status, String reason, String errorCode, String traceId) {
		this(status, reason, errorCode, traceId, (Throwable)null);
	}

	public BaseException(HttpStatus status, String reason, String errorCode, String traceId, Throwable cause) {
		super(status, reason, cause);
		this.errorCode = errorCode;
		this.traceId = traceId;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getTraceId() {
		return this.traceId;
	}

	public String getRootCauseName() {
		return this.rootCauseName;
	}

	public void setRootCauseName(String rootCauseName) {
		this.rootCauseName = rootCauseName;
	}

	public String getRootCauseMessage() {
		return this.rootCauseMessage;
	}

	public void setRootCauseMessage(String rootCauseMessage) {
		this.rootCauseMessage = rootCauseMessage;
	}

	public String getMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append(super.getMessage());
		messageBuilder.append("\n├").append(this.getClass().getName());
		messageBuilder.append("\n│\tError-Code: ").append(this.errorCode);
		messageBuilder.append("\n│\tTrace-ID: ").append(this.traceId);
		if (this.rootCauseName != null) {
			messageBuilder.append("\n│\tRoot-Cause: ").append(this.rootCauseName);
		}

		if (this.rootCauseMessage != null) {
			messageBuilder.append("\n│\tRoot-Cause-Message: ").append(this.rootCauseMessage);
		}

		return messageBuilder.toString();
	}
}

