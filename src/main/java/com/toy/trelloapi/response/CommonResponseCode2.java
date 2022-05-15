package com.toy.trelloapi.response;

import com.toy.trelloapi.utils.StringUtil;

public enum CommonResponseCode2 implements ResponseCode2 {
	RES_SUCCESS("Success"),
	RES_100("100"),
	RES_101("101"),
	RES_103("103"),
	RES_200("200"),
	RES_201("201"),
	RES_202("202"),
	RES_203("203"),
	RES_204("204"),
	RES_205("205"),
	RES_206("206"),
	RES_300("300"),
	RES_301("301"),
	RES_302("302"),
	RES_303("303"),
	RES_304("304"),
	RES_307("307"),
	RES_308("308"),
	RES_400("400"),
	RES_401("401"),
	RES_402("402"),
	RES_403("403"),
	RES_404("404"),
	RES_405("405"),
	RES_406("406"),
	RES_407("407"),
	RES_408("408"),
	RES_409("409"),
	RES_410("410"),
	RES_411("411"),
	RES_412("412"),
	RES_413("413"),
	RES_414("414"),
	RES_415("415"),
	RES_416("416"),
	RES_417("417"),
	RES_422("422"),
	RES_425("425"),
	RES_426("426"),
	RES_428("428"),
	RES_429("429"),
	RES_431("431"),
	RES_451("451"),
	RES_500("500"),
	RES_501("501"),
	RES_502("502"),
	RES_503("503"),
	RES_504("504"),
	RES_505("505"),
	RES_506("506"),
	RES_507("507"),
	RES_508("508"),
	RES_510("510"),
	RES_511("511");

	private final String resultCode;

	private CommonResponseCode2(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultCode() {
		return this.resultCode;
	}

	public static CommonResponseCode2 resolve(String resultCode) {
		if (StringUtil.isEmpty(resultCode)) {
			return null;
		} else {
			CommonResponseCode2[] resCodes = values();
			CommonResponseCode2[] var2 = resCodes;
			int var3 = resCodes.length;

			for(int var4 = 0; var4 < var3; ++var4) {
				CommonResponseCode2 resCode = var2[var4];
				if (resultCode.equals(resCode.resultCode)) {
					return resCode;
				}
			}

			return null;
		}
	}
}

