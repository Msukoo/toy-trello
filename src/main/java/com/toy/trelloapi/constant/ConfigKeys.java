package com.toy.trelloapi.constant;

public class ConfigKeys {
	public static final String DEFAULT = "default";
	public static final String CLASSPATH = "classpath:";

	/**
	 * <PRE>
	 *     Common Configuration Keys
	 * </PRE>
	 */

	public static final String APPLICATION_PREFIX = ".application";
	public static final String KEY_APPLICATION_TYPE = APPLICATION_PREFIX + ".type";
	public static final String APPLICATION_BASE_PACKAGE = APPLICATION_PREFIX + ".base-package";

	public static final String LANGUAGE = ".language";

	/**
	 * <PRE>
	 *     ErrorCode Configuration Keys
	 * </PRE>
	 */
	public static final String ERROR_PREFIX = "error";
	public static final String ERROR_MESSAGE_PREFIX = ERROR_PREFIX + "message";
	public static final String KEY_ERROR_MESSAGE_PROPERTY_BASE_DIR = ERROR_MESSAGE_PREFIX + ".base-directory";

	/**
	 * <PRE>
	 *     Message Configuration Keys
	 * </PRE>
	 */
	public static final String MESSAGES_PREFIX = ".messages";
	public static final String KEY_MESSAGES_PROPERTY_BASE_DIR = MESSAGES_PREFIX + ".base-directory";

	/**
	 * <PRE>
	 *     ResponseCode Configuration Keys
	 * </PRE>
	 */
	public static final String RESPONSE_PREFIX = "response";
	public static final String RESPONSE_MESSAGE_PREFIX = RESPONSE_PREFIX + ".message";
	public static final String KEY_RESPONSE_MESSAGES_PROPERTY_BASE_DIR = RESPONSE_MESSAGE_PREFIX + ".base-directory";
}
