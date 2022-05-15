package com.toy.trelloapi.utils;

import com.toy.trelloapi.constant.Delimiters;
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

	private static Properties toyResponseMessageProperties;

	@Qualifier("responseMessageProperties")
	@Autowired
	private Properties responseMessageProperties;

	public static final String RESPONSE_PROPERTY_PREFIX = "response";
	public static final String RESPONSE_PROPERTY_DEFAULT_PREFIX = RESPONSE_PROPERTY_PREFIX + ".default";

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 * </PRE>
	 *
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse() {
		return makeResponse(null, null, null, null);
	}//end: makeResponse()

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 * </PRE>
	 *
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(T body) {
		return makeResponse(null, null, body, null);
	}//end: makeResponse(T value)

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(ResponseCode resCode) {
		return makeResponse(resCode, null, null, null);
	}//end: makeResponse(T body, String additionalMessage)

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 인자
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(ResponseCode resCode, Object[] messageParams) {
		return makeResponse(resCode, messageParams, null, null);
	}

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(ResponseCode resCode, T body) {
		return makeResponse(resCode, null, body, null);
	}

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 인자
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(ResponseCode resCode, Object[] messageParams, T body) {
		return makeResponse(resCode, messageParams, body, null);
	}//end: makeResponse(T body, String additionalMessage)

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 *
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(T body, PagingInfo paging) {
		return makeResponse(null, null, body, paging);
	}//end: makeResponse(T body, PagingInfo paging)

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함되고,
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(ResponseCode resCode, T body, PagingInfo paging) {
		return makeResponse(resCode, null, body, paging);
	}//end: makeResponse(T body, PagingInfo paging)

	/**
	 * <PRE>
	 *      표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함되고,
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 전달인자
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @return  표준 응답 메시지 객체
	 */
	public static <T> Response<T> makeResponse(ResponseCode resCode, Object[] messageParams, T body, PagingInfo paging) {
		ResponseHeader header = makeHeader(resCode, messageParams);

		if (body == null) {
			body = (T) new ResponseBody();
		}

		Response<T> response = new Response<>();
		response.setHeader(header);
		response.setBody(body);

		if (paging != null) {
			response.setPaging(paging);
		}

		return response;
	}

	/**
	 * <PRE>
	 *     성공시, Header 객체를 만들어서 반환한다.
	 * </PRE>
	 *
	 * @return 성공시, Header 객체
	 */
	public static ResponseHeader makeDefaultHeader() {
		return buildResponseHeader(CommonResponseCode.RES_200);
	}

	/**
	 * <PRE>
	 *     성공시, Header 객체를 만들어서 반환한다.
	 * </PRE>
	 *
	 * @return 성공시, Header 객체
	 */
	public static ResponseHeader makeHeader(ResponseCode resCode) {
		return makeHeader(resCode, null);
	}

	/**
	 * <PRE>
	 *     성공시, Header 객체를 만들어서 반환한다.
	 * </PRE>
	 * @param resCode 메세지 코드
	 * @param messageParams 메세지 전달인자
	 * @return
	 */
	public static ResponseHeader makeHeader(ResponseCode resCode, Object[] messageParams) {
		ResponseHeader header = buildResponseHeader(resCode, messageParams);
		if (header == null) {
			return makeDefaultHeader();
		}
		return header;
	}

	/**
	 * <PRE>
	 *     기본 메시지 셋팅
	 * </PRE>
	 * @param resCode 메시지 코드
	 * @return
	 */
	private static ResponseHeader buildResponseHeader(ResponseCode resCode) {
		return buildResponseHeader(resCode, null);
	}

	/**
	 * <PRE>
	 *     기본 메시지 셋팅
	 * </PRE>
	 *
	 * @param resCode 메시지 코드
	 * @param messageParams 전달 인자
	 * @return
	 */
	private static ResponseHeader buildResponseHeader(ResponseCode resCode, Object[] messageParams) {
		if (resCode == null) {
			return null;
		}

		String lang = LocaleContextHolder.getLocale().getLanguage();
		if (StringUtil.isEmpty(lang)) {
			lang = "ko";
		}
		String status = resCode.getStatus();
		Object value = toyResponseMessageProperties.get(RESPONSE_PROPERTY_PREFIX + Delimiters.PERIOD + lang + Delimiters.PERIOD + resCode);

		if (value == null) {
			return null;
		}

		String message = value.toString();

		if (ArrayUtils.isNotEmpty(messageParams)) {
			message = StringUtil.format(message, messageParams);
		}

		ResponseHeader header = new ResponseHeader();
		header.setStatus(status);
		header.setMessage(message);

		return header;
	}

	@PostConstruct
	private void initResponseMessageProperties() {
		toyResponseMessageProperties = this.responseMessageProperties;
	}

}