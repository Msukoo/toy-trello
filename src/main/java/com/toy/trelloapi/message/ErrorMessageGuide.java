package com.toy.trelloapi.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class ErrorMessageGuide {
	public ErrorMessageGuide() {
	}

	@ApiModel(
		description = "401 에러 응답 형식"
	)
	public static class Response401Guide {
		@ApiModelProperty(
			notes = "수행시간",
			example = "2022-03-25,12:15:18.226+0900"
		)
		private String timestamp;
		@ApiModelProperty(
			notes = "상태",
			example = "401"
		)
		private int status;
		@ApiModelProperty(
			notes = "에러",
			example = "Unauthorized"
		)
		private String error;
		@ApiModelProperty(
			notes = "메세지",
			example = "401 UNAUTHORIZED\\n├com.toy.trelloapi.exception.ApiException\\n│\\tError-Code: SESSION_TIMEOUT_ERROR\\n│\\tTrace-ID: \\n│\\tGuide-Message: 인증 정보가 만료되었습니다.<br>다시 로그인 하세요."
		)
		private String message;
		@ApiModelProperty(
			notes = "상세 에러 가이드 메세지 - 커스텀 에러 메세지",
			example = "인증 정보가 만료되었습니다.<br>다시 로그인 하세요."
		)
		private String guideMessage;
		@ApiModelProperty(
			notes = "상세 에러 코드 - 커스텀 에러 코드",
			example = "SESSION_TIMEOUT_ERROR"
		)
		private String errorCode;
		@ApiModelProperty(
			notes = "에러 사유",
			example = "Unauthorized"
		)
		private String reason;
		@ApiModelProperty(
			notes = "예외 발생 위치",
			example = "com.toy.trelloapi.exception.ApiException"
		)
		private String exceptionName;
		@ApiModelProperty(
			notes = "traceId(Optional)",
			example = ""
		)
		private String traceId;

		public Response401Guide() {
		}

		public String getTimestamp() {
			return this.timestamp;
		}

		public int getStatus() {
			return this.status;
		}

		public String getError() {
			return this.error;
		}

		public String getMessage() {
			return this.message;
		}

		public String getGuideMessage() {
			return this.guideMessage;
		}

		public String getErrorCode() {
			return this.errorCode;
		}

		public String getReason() {
			return this.reason;
		}

		public String getExceptionName() {
			return this.exceptionName;
		}

		public String getTraceId() {
			return this.traceId;
		}

		public void setTimestamp(final String timestamp) {
			this.timestamp = timestamp;
		}

		public void setStatus(final int status) {
			this.status = status;
		}

		public void setError(final String error) {
			this.error = error;
		}

		public void setMessage(final String message) {
			this.message = message;
		}

		public void setGuideMessage(final String guideMessage) {
			this.guideMessage = guideMessage;
		}

		public void setErrorCode(final String errorCode) {
			this.errorCode = errorCode;
		}

		public void setReason(final String reason) {
			this.reason = reason;
		}

		public void setExceptionName(final String exceptionName) {
			this.exceptionName = exceptionName;
		}

		public void setTraceId(final String traceId) {
			this.traceId = traceId;
		}

		public String toString() {
			String var10000 = this.getTimestamp();
			return "ErrorMessageGuide.Response401Guide(timestamp=" + var10000 + ", status=" + this.getStatus() + ", error=" + this.getError() + ", message=" + this.getMessage() + ", guideMessage=" + this.getGuideMessage() + ", errorCode=" + this.getErrorCode() + ", reason=" + this.getReason() + ", exceptionName=" + this.getExceptionName() + ", traceId=" + this.getTraceId() + ")";
		}
	}

	@ApiModel(
		description = "400 에러 응답 형식"
	)
	public static class Response400Guide {
		@ApiModelProperty(
			notes = "수행시간",
			example = "2022-03-24T06:57:05.963+00:00"
		)
		private String timestamp;
		@ApiModelProperty(
			notes = "상태",
			example = "400"
		)
		private int status;
		@ApiModelProperty(
			notes = "URL",
			example = "/demo/validate-request-body"
		)
		private String path;
		@ApiModelProperty(
			notes = "에러",
			example = "Bad Request"
		)
		private String error;
		@ApiModelProperty(
			notes = "메세지",
			example = "필수값 입니다."
		)
		private String message;
		@ApiModelProperty(
			notes = "상세 에러 가이드 메세지 - 커스텀 에러 메세지",
			example = "1개의 값이 잘못 입력되었습니다.\\n\\t├ demoMemberRequestDTO 의 memId 은 필수값 입니다."
		)
		private String guideMessage;
		@ApiModelProperty(
			notes = "상세 에러 코드 - 커스텀 에러 코드(Optional)",
			example = ""
		)
		private String errorCode;
		@ApiModelProperty(
			notes = "어플리케이션 명(Optional)",
			example = "trello-api"
		)
		private String application;
		@ApiModelProperty(
			notes = "에러 사유(Optional)",
			example = "Internal Server Error"
		)
		private String reason;
		@ApiModelProperty(
			notes = "예외 발생 위치(Optional)",
			example = "com.toy.trelloapi.exception.ApiException"
		)
		private String exceptionName;

		public Response400Guide() {
		}

		public String getTimestamp() {
			return this.timestamp;
		}

		public int getStatus() {
			return this.status;
		}

		public String getPath() {
			return this.path;
		}

		public String getError() {
			return this.error;
		}

		public String getMessage() {
			return this.message;
		}

		public String getGuideMessage() {
			return this.guideMessage;
		}

		public String getErrorCode() {
			return this.errorCode;
		}

		public String getApplication() {
			return this.application;
		}

		public String getReason() {
			return this.reason;
		}

		public String getExceptionName() {
			return this.exceptionName;
		}

		public void setTimestamp(final String timestamp) {
			this.timestamp = timestamp;
		}

		public void setStatus(final int status) {
			this.status = status;
		}

		public void setPath(final String path) {
			this.path = path;
		}

		public void setError(final String error) {
			this.error = error;
		}

		public void setMessage(final String message) {
			this.message = message;
		}

		public void setGuideMessage(final String guideMessage) {
			this.guideMessage = guideMessage;
		}

		public void setErrorCode(final String errorCode) {
			this.errorCode = errorCode;
		}

		public void setApplication(final String application) {
			this.application = application;
		}

		public void setReason(final String reason) {
			this.reason = reason;
		}

		public void setExceptionName(final String exceptionName) {
			this.exceptionName = exceptionName;
		}

		public String toString() {
			String var10000 = this.getTimestamp();
			return "ErrorMessageGuide.Response400Guide(timestamp=" + var10000 + ", status=" + this.getStatus() + ", path=" + this.getPath() + ", error=" + this.getError() + ", message=" + this.getMessage() + ", guideMessage=" + this.getGuideMessage() + ", errorCode=" + this.getErrorCode() + ", application=" + this.getApplication() + ", reason=" + this.getReason() + ", exceptionName=" + this.getExceptionName() + ")";
		}
	}
}
