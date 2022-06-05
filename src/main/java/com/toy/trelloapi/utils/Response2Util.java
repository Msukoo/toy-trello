package com.toy.trelloapi.utils;

import com.toy.trelloapi.constant.Delimiters;
import com.toy.trelloapi.message.Response2;
import com.toy.trelloapi.message.ResponseBody;
import com.toy.trelloapi.message.ResponseHeader2;
import com.toy.trelloapi.model.PagingInfo;
import com.toy.trelloapi.response.CommonResponseCode2;
import com.toy.trelloapi.response.ResponseCode2;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class Response2Util {

	private static Properties toyResponseMessageProperties;

	@Qualifier("responseMessageProperties")
	@Autowired
	private Properties responseMessageProperties;

	public static final String RESPONSE_PROPERTY_PREFIX = "response";
	public static final String RESPONSE_PROPERTY_DEFAULT_PREFIX = RESPONSE_PROPERTY_PREFIX + ".default";

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 * </PRE>
	 *
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse() {
		return makeResponse(null, null, null, null, null);
	}//end: makeResponse()

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 * </PRE>
	 *
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(T body) {
		return makeResponse(null, null, null, body, null);
	}//end: makeResponse(T value)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 * </PRE>
	 *
	 * @param resultData 응답 메시지의 header에 포함될 객체
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponseWithData(D resultData) {
		return makeResponse(null, null, resultData, null, null);
	}//end: makeResponse(T value)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode) {
		return makeResponse(resCode, null, null, null, null);
	}//end: makeResponse(T body, String additionalMessage)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 인자
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams) {
		return makeResponse(resCode, messageParams, null, null, null);
	}

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param resultData 응답 메시지의 header에 포함될 객체
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponseWithData(ResponseCode2 resCode, D resultData) {
		return makeResponse(resCode, null, resultData, null, null);
	}

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, T body) {
		return makeResponse(resCode, null, null, body, null);
	}

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 인자
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams, T body) {
		return makeResponse(resCode, messageParams, null, body, null);
	}//end: makeResponse(T body, String additionalMessage)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param resultData 응답 메시지의 header에 포함될 객체
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponseWithData(ResponseCode2 resCode, D resultData, T body) {
		return makeResponse(resCode, null, resultData, body, null);
	}

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 *
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(T body, PagingInfo paging) {
		return  makeResponse(null, null, null, body, paging);
	}//end: makeResponse(T body, PagingInfo paging)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 *
	 * @param resultData 응답 메시지의 header에 포함될 객체
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponseWithData(D resultData, T body, PagingInfo paging) {
		return  makeResponse(null, null, resultData, body, paging);
	}//end: makeResponse(T body, PagingInfo paging)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함되고,
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 *
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, T body, PagingInfo paging) {
		return makeResponse(resCode, null, body, paging);
	}//end: makeResponse(T body, PagingInfo paging)

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함되고,
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 전달인자
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams, T body, PagingInfo paging) {
		return makeResponse(resCode, messageParams, null, body, paging);
	}

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함되고,
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param resultData 응답 메시지의 header에 포함될 객체
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	public static <T, D> Response2<T, D> makeResponseWithData(ResponseCode2 resCode, D resultData, T body, PagingInfo paging) {
		return makeResponse(resCode, null, resultData, body, paging);
	}

	/**
	 * <PRE>
	 *     표준 응답 메시지 객체를 생성하여 반환한다.
	 *     응답 Header 에 추가 메시지가 포함되고,
	 *     페이징 정보가 포함됨.
	 * </PRE>
	 * @param resCode 응답 Header에 포함될 응답 코드
	 * @param messageParams 메시지 전달인자
	 * @param resultData header에 셋팅될 resultData
	 * @param body 응답 메시지의 body에 포함될 DTO 객체
	 * @param paging 페이징 정보
	 * @param <T> body 타입
	 * @param <D> resultData 타입
	 * @return 표준 응답 메시지 객체
	 */
	private static <T, D> Response2<T, D> makeResponse(ResponseCode2 resCode, Object[] messageParams, D resultData, T body, PagingInfo paging) {
		ResponseHeader2<D> header = makeHeader(resCode, messageParams, resultData);

		if (body == null) {
			body = (T) new ResponseBody();
		}

		Response2<T, D> response = new Response2<>();
		response.setHeader(header);
		response.setBody(body);

		if (paging != null) {
			response.setPaging(paging);
		}

		return response;
	}

	/**
	 * <PRE>
	 *     성공시, LfcpHeader 객체를 만들어서 반환한다.
	 * </PRE>
	 *
	 * @return 성공시, LfcpHeader 객체
	 */
	public static ResponseHeader2 makeDefaultHeader() {
		return buildResponseHeader(CommonResponseCode2.RES_SUCCESS, null, null);
	}

	/**
	 * <PRE>
	 *     성공시, LfcpHeader 객체를 만들어서 반환한다.
	 * </PRE>
	 *
	 * @return 성공시, LfcpHeader 객체
	 */
	public static ResponseHeader2 makeHeader(ResponseCode2 resCode) {
		return buildResponseHeader(resCode, null, null);
	}

	/**
	 * <PRE>
	 *     성공시, LfcpHeader 객체를 만들어서 반환한다.
	 * </PRE>
	 * @param resCode 메세지 코드
	 * @param messageParams 메세지 전달인자
	 * @return
	 */
	public static ResponseHeader2 makeHeader(ResponseCode2 resCode, Object[] messageParams) {
		return buildResponseHeader(resCode, messageParams, null);
	}

	/**
	 * <PRE>
	 *		성공시, LfcpHeader 객체를 만들어서 반환한다.
	 * </PRE>
	 * @param resCode resultCode
	 * @param resultData 셋팅될 데이터
	 * @return
	 */
	public static ResponseHeader2 makeHeader(ResponseCode2 resCode, Object resultData) {
		return buildResponseHeader(resCode, null, resultData);
	}

	/**
	 * <PRE>
	 *     성공시, LfcpHeader 객체를 만들어서 반환한다.
	 * </PRE>
	 * @param resCode 메세지 코드
	 * @param messageParams 메세지 전달인자
	 * @param resultData 셋팅 데이터
	 * @return
	 */
	private static <D> ResponseHeader2 makeHeader(ResponseCode2 resCode, Object[] messageParams, D resultData) {
		return buildResponseHeader(resCode, messageParams, resultData);
	}

	/**
	 * <PRE>
	 *     기본 메시지 셋팅
	 * </PRE>
	 *
	 * @param resCode 메시지 코드
	 * @param messageParams 전달 인자
	 * @param  resultData messageParams보다 우선순위, null일경우에만 messageParams 셋팅
	 * @return
	 */
	private static <T> ResponseHeader2<T> buildResponseHeader(ResponseCode2 resCode, Object[] messageParams, T resultData) {
		if (resCode == null) {
			resCode = CommonResponseCode2.RES_SUCCESS;
		}

		// header 생성
		ResponseHeader2 header = new ResponseHeader2();
		header.setResultCode(resCode.getResultCode());

		// resultData가 우선순위가 높음.
		if(resultData != null) {
			header.setResultData(resultData);
			return  header;
		}

		// 메시지 Param을 체크하여 처리
		String lang = LocaleContextHolder.getLocale().getLanguage();
		if (StringUtil.isEmpty(lang)) {
			lang = "ko";
		}

		Object messageObject = toyResponseMessageProperties.get(RESPONSE_PROPERTY_PREFIX + Delimiters.PERIOD + lang + Delimiters.PERIOD + resCode);
		if(messageObject == null) {
			header.setResultData("");
			return header;
		}

		String targetMsg = messageObject.toString();
		if(ArrayUtils.isNotEmpty(messageParams)) {
			targetMsg = StringUtil.format(targetMsg, messageParams);
		}

		header.setResultData(targetMsg);
		return header;
	}

	@PostConstruct
	private void inittoyResponseMessageProperties() {
		toyResponseMessageProperties = this.responseMessageProperties;
	}

}