package com.toy.trelloapi.message;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody {
	private String defaultBody;

	public ResponseBody() {
	}

	public String getDefaultBody() {
		return this.defaultBody;
	}

	public void setDefaultBody(final String defaultBody) {
		this.defaultBody = defaultBody;
	}

	public String toString() {
		return "ResponseBody(defaultBody=" + this.getDefaultBody() + ")";
	}
}
