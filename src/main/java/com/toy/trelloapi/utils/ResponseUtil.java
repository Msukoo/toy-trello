package com.toy.trelloapi.utils;

import com.toy.trelloapi.message.Response;
import com.toy.trelloapi.message.ResponseBody;
import com.toy.trelloapi.message.ResponseHeader;
import com.toy.trelloapi.model.PagingInfo;
import com.toy.trelloapi.response.CommonResponseCode;
import com.toy.trelloapi.response.ResponseCode;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class ResponseUtil {
	private static Properties ResponseMessageProperties;
	@Qualifier("ResponseMessageProperties")
	/*@Autowired*/
	private Properties responseMessageProperties;
	public static final String RESPONSE_PROPERTY_PREFIX = "response";
	public static final String RESPONSE_PROPERTY_DEFAULT_PREFIX = "response.default";

	public ResponseUtil() {
	}

	public static <T> Response<Object> makeResponse() {
		return makeResponse((ResponseCode)null, (Object[])null, (Object)null, (PagingInfo)null);
	}

	public static <T> Response<T> makeResponse(T body) {
		return makeResponse((ResponseCode)null, (Object[])null, body, (PagingInfo)null);
	}

	public static <T> Response<Object> makeResponse(ResponseCode resCode) {
		return makeResponse(resCode, (Object[])null, (Object)null, (PagingInfo)null);
	}

	public static <T> Response<Object> makeResponse(ResponseCode resCode, Object[] messageParams) {
		return makeResponse(resCode, messageParams, (Object)null, (PagingInfo)null);
	}

	public static <T> Response<T> makeResponse(ResponseCode resCode, T body) {
		return makeResponse(resCode, (Object[])null, body, (PagingInfo)null);
	}

	public static <T> Response<T> makeResponse(ResponseCode resCode, Object[] messageParams, T body) {
		return makeResponse(resCode, messageParams, body, (PagingInfo)null);
	}

	public static <T> Response<T> makeResponse(T body, PagingInfo paging) {
		return makeResponse((ResponseCode)null, (Object[])null, body, paging);
	}

	public static <T> Response<T> makeResponse(ResponseCode resCode, Object[] objects, T body, PagingInfo paging) {
		return makeResponse(resCode, (Object[])null, body, paging);
	}

	public static <T> Response<ResponseBody> makeResponse(ResponseCode resCode, Object[] messageParams, ResponseBody body) {
		ResponseHeader header = makeHeader(resCode, messageParams);
		if (body == null) {
			body = new ResponseBody();
		}

		Response<ResponseBody> response = new Response();
		response.setHeader(header);
		response.setBody(body);

		return response;
	}

	public static ResponseHeader makeDefaultHeader() {
		return buildResponseHeader(CommonResponseCode.RES_200);
	}

	public static ResponseHeader makeHeader(ResponseCode resCode) {
		return makeHeader(resCode, (Object[])null);
	}

	public static ResponseHeader makeHeader(ResponseCode resCode, Object[] messageParams) {
		ResponseHeader header = buildResponseHeader(resCode, messageParams);
		return header == null ? makeDefaultHeader() : header;
	}

	private static ResponseHeader buildResponseHeader(ResponseCode resCode) {
		return buildResponseHeader(resCode, (Object[])null);
	}

	private static ResponseHeader buildResponseHeader(ResponseCode resCode, Object[] messageParams) {
		if (resCode == null) {
			return null;
		} else {
			String lang = LocaleContextHolder.getLocale().getLanguage();
			if (StringUtil.isEmpty(lang)) {
				lang = "ko";
			}

			String status = resCode.getStatus();
			Object value = ResponseMessageProperties.get("response." + lang + "." + resCode);
			if (value == null) {
				return null;
			} else {
				String message = value.toString();
				if (ArrayUtils.isNotEmpty(messageParams)) {
					message = StringUtil.format(message, messageParams);
				}

				ResponseHeader header = new ResponseHeader();
				header.setStatus(status);
				header.setMessage(message);
				return header;
			}
		}
	}

	@PostConstruct
	private void initResponseMessageProperties() {
		ResponseMessageProperties = this.responseMessageProperties;
	}
}
