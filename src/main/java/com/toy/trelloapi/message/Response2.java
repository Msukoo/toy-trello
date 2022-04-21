package com.toy.trelloapi.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.toy.trelloapi.model.PagingInfo;

public class Response2<T, D> extends Message {
	private ResponseHeader2<D> header;
	private T body;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private PagingInfo paging;

	public Response2() {
	}

	public ResponseHeader2<D> getHeader() {
		return this.header;
	}

	public T getBody() {
		return this.body;
	}

	public PagingInfo getPaging() {
		return this.paging;
	}

	public void setHeader(final ResponseHeader2<D> header) {
		this.header = header;
	}

	public void setBody(final T body) {
		this.body = body;
	}

	public void setPaging(final PagingInfo paging) {
		this.paging = paging;
	}

	public String toString() {
		ResponseHeader2 var10000 = this.getHeader();
		return "Response2(header=" + var10000 + ", body=" + this.getBody() + ", paging=" + this.getPaging() + ")";
	}
}
