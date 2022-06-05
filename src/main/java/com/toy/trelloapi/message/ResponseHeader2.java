package com.toy.trelloapi.message;

import io.swagger.annotations.ApiModelProperty;

public class ResponseHeader2<D> extends Message {
	@ApiModelProperty(
		notes = "응답에 대한 코드",
		example = "\"200\""
	)
	private String resultCode;
	@ApiModelProperty(
		notes = "헤더에 셋팅될 데이터",
		example = "정상 처리 되었습니다."
	)
	private D resultData;

	public ResponseHeader2() {
	}

	public String getResultCode() {
		return this.resultCode;
	}

	public D getResultData() {
		return this.resultData;
	}

	public void setResultCode(final String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultData(final D resultData) {
		this.resultData = resultData;
	}

	public String toString() {
		String var10000 = this.getResultCode();
		return "ResponseHeader2(resultCode=" + var10000 + ", resultData=" + this.getResultData() + ")";
	}
}
