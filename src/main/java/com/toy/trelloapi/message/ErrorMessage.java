package com.toy.trelloapi.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;

@ApiModel(
	description = "공통 에러 응답 형식"
)
public class ErrorMessage extends Message {
	@ApiModelProperty(
		notes = "수행시간",
		example = "2022-03-24T06:57:05.963+00:00"
	)
	private String timestamp;
	@ApiModelProperty(
		notes = "상태",
		example = "500"
	)
	private int status;
	@ApiModelProperty(
		hidden = true
	)
	private int code;
	@ApiModelProperty(
		notes = "에러",
		example = "Internal Server Error"
	)
	private String error;
	@ApiModelProperty(
		hidden = true
	)
	private List<FieldError> errors;
	@ApiModelProperty(
		hidden = true
	)
	private String exception;
	@ApiModelProperty(
		notes = "메세지",
		example = ""
	)
	private String message;
	@ApiModelProperty(
		notes = "URL",
		example = "/v1/card"
	)
	private String path;
	@ApiModelProperty(
		hidden = true
	)
	private String trace;
	@ApiModelProperty(
		notes = "상세 에러 코드 - 커스텀 에러 코드",
		example = "MEMBER_LOGIN_SESSION_EMPTY"
	)
	private String errorCode;
	@ApiModelProperty(
		notes = "어플리케이션 명",
		example = "trello-api"
	)
	private String application;
	@ApiModelProperty(
		hidden = true
	)
	private String traceId;
	@ApiModelProperty(
		notes = "에러 사유",
		example = "Internal Server Error"
	)
	private String reason;
	@ApiModelProperty(
		hidden = true
	)
	private String displayMessage;
	@ApiModelProperty(
		notes = "상세 에러 가이드 메세지 - 커스텀 에러 메세지",
		example = "로그인 세션 정보가 존재하지 않습니다."
	)
	private String guideMessage;
	@ApiModelProperty(
		hidden = true
	)
	private String detailMessage;
	@ApiModelProperty(
		notes = "예외 발생 위치",
		example = "com.toy.trelloapi.common.exception.ApiException"
	)
	private String exceptionName;
	@ApiModelProperty(
		hidden = true
	)
	private String rootCause;
	@ApiModelProperty(
		hidden = true
	)
	private String rootCauseMessage;
	@ApiModelProperty(
		hidden = true
	)
	private StackTraceElement[] stackTrace;
	@ApiModelProperty(
		hidden = true
	)
	private String exceptionDetail;

	public ErrorMessage() {
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public int getStatus() {
		return this.status;
	}

	public int getCode() {
		return this.code;
	}

	public String getError() {
		return this.error;
	}

	public List<FieldError> getErrors() {
		return this.errors;
	}

	public String getException() {
		return this.exception;
	}

	public String getMessage() {
		return this.message;
	}

	public String getPath() {
		return this.path;
	}

	public String getTrace() {
		return this.trace;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getApplication() {
		return this.application;
	}

	public String getTraceId() {
		return this.traceId;
	}

	public String getReason() {
		return this.reason;
	}

	public String getDisplayMessage() {
		return this.displayMessage;
	}

	public String getGuideMessage() {
		return this.guideMessage;
	}

	public String getDetailMessage() {
		return this.detailMessage;
	}

	public String getExceptionName() {
		return this.exceptionName;
	}

	public String getRootCause() {
		return this.rootCause;
	}

	public String getRootCauseMessage() {
		return this.rootCauseMessage;
	}

	public StackTraceElement[] getStackTrace() {
		return this.stackTrace;
	}

	public String getExceptionDetail() {
		return this.exceptionDetail;
	}

	public void setTimestamp(final String timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatus(final int status) {
		this.status = status;
	}

	public void setCode(final int code) {
		this.code = code;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public void setErrors(final List<FieldError> errors) {
		this.errors = errors;
	}

	public void setException(final String exception) {
		this.exception = exception;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	public void setTrace(final String trace) {
		this.trace = trace;
	}

	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	public void setApplication(final String application) {
		this.application = application;
	}

	public void setTraceId(final String traceId) {
		this.traceId = traceId;
	}

	public void setReason(final String reason) {
		this.reason = reason;
	}

	public void setDisplayMessage(final String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public void setGuideMessage(final String guideMessage) {
		this.guideMessage = guideMessage;
	}

	public void setDetailMessage(final String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public void setExceptionName(final String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public void setRootCause(final String rootCause) {
		this.rootCause = rootCause;
	}

	public void setRootCauseMessage(final String rootCauseMessage) {
		this.rootCauseMessage = rootCauseMessage;
	}

	public void setStackTrace(final StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}

	public void setExceptionDetail(final String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public String toString() {
		String var10000 = this.getTimestamp();
		return "ErrorMessage(timestamp=" + var10000 + ", status=" + this.getStatus() + ", code=" + this.getCode() + ", error=" + this.getError() + ", errors=" + this.getErrors() + ", exception=" + this.getException() + ", message=" + this.getMessage() + ", path=" + this.getPath() + ", trace=" + this.getTrace() + ", errorCode=" + this.getErrorCode() + ", application=" + this.getApplication() + ", traceId=" + this.getTraceId() + ", reason=" + this.getReason() + ", displayMessage=" + this.getDisplayMessage() + ", guideMessage=" + this.getGuideMessage() + ", detailMessage=" + this.getDetailMessage() + ", exceptionName=" + this.getExceptionName() + ", rootCause=" + this.getRootCause() + ", rootCauseMessage=" + this.getRootCauseMessage() + ", stackTrace=" + Arrays.deepToString(this.getStackTrace()) + ", exceptionDetail=" + this.getExceptionDetail() + ")";
	}
}
