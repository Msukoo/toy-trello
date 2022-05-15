package com.toy.trelloapi.message;

import io.swagger.annotations.ApiModelProperty;

public class ResponseHeader extends Message {
	@ApiModelProperty(
		notes = "응답에 대한 status",
		example = "\"200\""
	)
	private String status;
	@ApiModelProperty(
		notes = "status에 대한 메세지",
		example = "정상 처리 되었습니다."
	)
	private String message;

	public ResponseHeader() {
	}

	public String getStatus() {
		return this.status;
	}

	public String getMessage() {
		return this.message;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String toString() {
		String var10000 = this.getStatus();
		return "ResponseHeader(status=" + var10000 + ", message=" + this.getMessage() + ")";
	}
}
