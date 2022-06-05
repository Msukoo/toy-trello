package com.toy.trelloapi.domain.response;

import com.toy.trelloapi.response.ResponseCode2;
import com.toy.trelloapi.utils.StringUtil;

public enum CardResponseCode implements ResponseCode2 {
	CARD_RESPONSE_SUCCESS ("SUCCESS"),
	CARD_RESPONSE_200 ("200"),
	CARD_RESPONSE_404 ("404");

	private final String resultCode;

	CardResponseCode(String resultCode) {
		this.resultCode = resultCode;
	}

	@Override
	public String getResultCode() {
		return this.resultCode;
	}

	/**
	 * <PRE>
	 *     응답코드를 찾아서 리턴한다.
	 *     입력된 code 값이 null 이거나 white space 인경우, null 을 리턴한다.
	 *     찾는 응답코드가 없으면, null 을 리턴한다.
	 * </PRE>
	 *
	 * @param status 응답코드
	 * @return 응답코드 Enum 값
	 */
	public static CardResponseCode resolve(String status) {
		if (StringUtil.isEmpty(status)) {
			return null;
		}//end: if

		CardResponseCode[] resCodes = values();
		for (CardResponseCode resCode : resCodes ) {
			if(status.equals(resCode.resultCode)) {
				return resCode;
			}//end if
		}//end: for-loop

		return null;
	}//end: resolve(String)
}
