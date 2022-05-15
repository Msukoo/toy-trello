package com.toy.trelloapi.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends BaseException {
	private final String guideMessage;

    public ApiException(HttpStatus status, String errorCode, String traceId, String guideMessage) {
		this(status, (String)null, errorCode, traceId, guideMessage, (Throwable)null);
	}

    public ApiException(HttpStatus status, String errorCode, String traceId, String guideMessage, Throwable cause) {
		this(status, (String)null, errorCode, traceId, guideMessage, cause);
	}

    public ApiException(HttpStatus status, String reason, String errorCode, String traceId, String guideMessage) {
		this(status, reason, errorCode, traceId, guideMessage, (Throwable)null);
	}

    public ApiException(HttpStatus status, String reason, String errorCode, String traceId, String guideMessage, Throwable cause) {
		super(status, reason, errorCode, traceId, cause);
		this.guideMessage = guideMessage;
	}

	public String getGuideMessage() {
		return this.guideMessage;
	}

	public String getMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append(super.getMessage());
		if (this.guideMessage != null) {
			messageBuilder.append("\n│\tGuide-Message: ").append(this.guideMessage);
		}

		return messageBuilder.toString();
	}
}

