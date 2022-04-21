package com.toy.trelloapi.utils;

import com.toy.trelloapi.message.Response2;
import com.toy.trelloapi.message.ResponseBody;
import com.toy.trelloapi.message.ResponseHeader2;
import com.toy.trelloapi.model.PagingInfo;
import com.toy.trelloapi.response.CommonResponseCode2;
import com.toy.trelloapi.response.ResponseCode2;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.annotation.PostConstruct;
import java.util.Properties;

public class Response2Util {
	private static Properties ResponseMessageProperties;
	@Qualifier("ResponseMessageProperties")
	/*@Autowired*/
	private Properties responseMessageProperties;
	public static final String RESPONSE_PROPERTY_PREFIX = "response";
	public static final String RESPONSE_PROPERTY_DEFAULT_PREFIX = "response.default";

	public Response2Util() {
	}

	public static <T, D> Response2<T, D> makeResponse() {
		return (Response2<T, D>) makeResponse((ResponseCode2)null, (Object[])null, (Object)null, (Object)null, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponse(T body) {
		return (Response2<T, D>) makeResponse((ResponseCode2)null, (Object[])null, (Object)null, body, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponseWithData(D resultData) {
		return (Response2<T, D>) makeResponse((ResponseCode2)null, (Object[])null, resultData, (Object)null, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode) {
		return (Response2<T, D>) makeResponse(resCode, (Object[])null, (Object)null, (Object)null, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams) {
		return (Response2<T, D>) makeResponse(resCode, messageParams, (Object)null, (Object)null, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponseWithData(ResponseCode2 resCode, D resultData) {
		return (Response2<T, D>) makeResponse(resCode, (Object[])null, resultData, (Object)null, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, T body) {
		return (Response2<T, D>) makeResponse(resCode, (Object[])null, (Object)null, body, (PagingInfo)null);
	}

	public static <T, D> Response2<T, Object> makeResponse(ResponseCode2 resCode, Object[] messageParams, T body) {
		return makeResponse(resCode, messageParams, (Object)null, body, (PagingInfo)null);
	}

	public static <T, D> Response2<T, D> makeResponseWithData(ResponseCode2 resCode, D resultData, T body) {
		return makeResponse(resCode, (Object[])null, resultData, body, (PagingInfo)null);
	}

	public static <T, D> Response2<T, Object> makeResponse(T body, PagingInfo paging) {
		return makeResponse((ResponseCode2)null, (Object[])null, (Object)null, body, paging);
	}

	public static <T, D> Response2<T, D> makeResponseWithData(D resultData, T body, PagingInfo paging) {
		return makeResponse((ResponseCode2)null, (Object[])null, resultData, body, paging);
	}

	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, T body, PagingInfo paging) {
		return makeResponse(resCode, (Object[])null, body, paging);
	}

	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams, T body, PagingInfo paging) {
		return (Response2<T, D>) makeResponse(resCode, messageParams, (Object)null, body, paging);
	}

	public static <T, D> Response2<T, D> makeResponseWithData(ResponseCode2 resCode, D resultData, T body, PagingInfo paging) {
		return makeResponse(resCode, (Object[])null, resultData, body, paging);
	}

	private static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams, D resultData, T body, PagingInfo paging) {
		ResponseHeader2<D> header = makeHeader(resCode, messageParams, resultData);
		if (body == null) {
			body = (T) new ResponseBody();
		}

		Response2<T, D> response = new Response2();
		response.setHeader(header);
		response.setBody(body);
		if (paging != null) {
			response.setPaging(paging);
		}

		return response;
	}

	public static ResponseHeader2 makeDefaultHeader() {
		return buildResponseHeader(CommonResponseCode2.RES_SUCCESS, (Object[])null, (Object)null);
	}

	public static ResponseHeader2 makeHeader(ResponseCode2 resCode) {
		return buildResponseHeader(resCode, (Object[])null, (Object)null);
	}

	public static ResponseHeader2 makeHeader(ResponseCode2 resCode, Object[] messageParams) {
		return buildResponseHeader(resCode, messageParams, (Object)null);
	}

	public static ResponseHeader2 makeHeader(ResponseCode2 resCode, Object resultData) {
		return buildResponseHeader(resCode, (Object[])null, resultData);
	}

	private static <D> ResponseHeader2 makeHeader(ResponseCode2 resCode, Object[] messageParams, D resultData) {
		return buildResponseHeader(resCode, messageParams, resultData);
	}

	private static <T> ResponseHeader2<T> buildResponseHeader(ResponseCode2 resCode, Object[] messageParams, T resultData) {
		if (resCode == null) {
			resCode = CommonResponseCode2.RES_200;
		}

		ResponseHeader2 header = new ResponseHeader2();
		header.setResultCode(((ResponseCode2)resCode).getResultCode());
		if (resultData != null) {
			header.setResultData(resultData);
			return header;
		} else {
			String lang = LocaleContextHolder.getLocale().getLanguage();
			if (StringUtil.isEmpty(lang)) {
				lang = "ko";
			}

			Object messageObject = ResponseMessageProperties.get("response." + lang + "." + resCode);
			if (messageObject == null) {
				header.setResultData("");
				return header;
			} else {
				String targetMsg = messageObject.toString();
				if (ArrayUtils.isNotEmpty(messageParams)) {
					targetMsg = StringUtil.format(targetMsg, messageParams);
				}

				header.setResultData(targetMsg);
				return header;
			}
		}
	}

	@PostConstruct
	private void initResponseMessageProperties() {
		ResponseMessageProperties = this.responseMessageProperties;
	}
}
