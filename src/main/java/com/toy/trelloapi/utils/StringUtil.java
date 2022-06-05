package com.toy.trelloapi.utils;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class StringUtil extends StringUtils {
	private static final Logger log = LoggerFactory.getLogger(StringUtil.class);
	private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd,HH:mm:ss.SSSZ";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss.SSSZ");
	private static final String CAMEL_CASE_EXPRESSION = "([a-z,0-9])([A-Z]+)";
	private static final String REPLACEMENT_KEBAPCASE = "$1-$2";

	public StringUtil() {
	}

	public static String convertDateToString(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("date argument is null");
		} else {
			return simpleDateFormat.format(date);
		}
	}

	public static String convertDateToString(Date date, String format) {
		if (date == null) {
			throw new IllegalArgumentException("date argument is null");
		} else if (isEmpty(format)) {
			throw new IllegalArgumentException("format argument is null or empty");
		} else {
			SimpleDateFormat dateFormat = null;

			try {
				dateFormat = new SimpleDateFormat(format);
			} catch (IllegalArgumentException var4) {
				throw new IllegalArgumentException("format argument is valiid : " + format);
			}

			return dateFormat.format(date);
		}
	}

	public static boolean isEmpty(String inputStr) {
		return inputStr == null || inputStr.trim().isEmpty();
	}

	public static boolean isYn(String inputStr) {
		return inputStr != null && "Y".equalsIgnoreCase(inputStr);
	}

	public static String format(String pattern, Object... arguments) {
		if (isEmpty(pattern)) {
			throw new IllegalArgumentException("pattern argument is null or empty");
		} else {
			MessageFormat messageFormat = new MessageFormat(pattern);
			StringBuffer messageBuffer = messageFormat.format(arguments, new StringBuffer(), new FieldPosition(0));
			return messageBuffer.toString();
		}
	}

	public static String format(String pattern, Object argument) {
		if (isEmpty(pattern)) {
			throw new IllegalArgumentException("pattern argument is null or empty");
		} else {
			Object[] arguments = new Object[]{argument};
			return format(pattern, arguments);
		}
	}

	public static String readToString(InputStream inputStream) throws IOException {
		if (inputStream == null) {
			throw new IllegalArgumentException("inputStream argument is null");
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			char[] charBuffer = new char[128];
			boolean var4 = true;

			try {
				int bytesRead;
				try {
					while((bytesRead = bufferedReader.read(charBuffer)) > 0) {
						stringBuilder.append(charBuffer, 0, bytesRead);
					}
				} catch (IOException var13) {
					log.error("Error while read inputStream", var13);
					throw var13;
				}
			} finally {
				try {
					bufferedReader.close();
				} catch (IOException var12) {
					log.warn("Error occured while close inputStream", var12);
				}

			}

			return stringBuilder.toString();
		}
	}

	public static String convertCamelcaseToKebabcase(String camelStr) {
		if (isEmpty(camelStr)) {
			throw new IllegalArgumentException("camelStr argument is null or empty");
		} else {
			return camelStr.replaceAll("([a-z,0-9])([A-Z]+)", "$1-$2").toLowerCase();
		}
	}

	public static String substrInBytes(String text, int maxLenInBytes) {
		if (StringUtils.hasLength(text) && text.getBytes().length > maxLenInBytes) {
			if (maxLenInBytes <= 0) {
				throw new IllegalArgumentException("value of maxLenInBytes must be greater than zero");
			} else {
				int len = text.length();
				int bytesLength = 0;
				StringBuilder sb = new StringBuilder();

				for(int idx = 0; idx < len; ++idx) {
					String s = text.substring(idx, idx + 1);
					bytesLength += s.getBytes().length;
					if (bytesLength <= maxLenInBytes) {
						sb.append(s);
					}
				}

				return sb.toString();
			}
		} else {
			return text;
		}
	}

	public static String getDefault(String inputValue, String defaultValue) {
		if (isEmpty(defaultValue)) {
			throw new IllegalArgumentException("defaultValue is null or empty");
		} else {
			return isEmpty(inputValue) ? defaultValue : inputValue;
		}
	}

	public static boolean isNumeric(String strNum) {
		if (isEmpty(strNum)) {
			return false;
		} else {
			try {
				Double.parseDouble(strNum);
				return true;
			} catch (NumberFormatException var2) {
				return false;
			}
		}
	}

	public static String encodeBase64(String plainText) {
		if (isEmpty(plainText)) {
			throw new IllegalArgumentException("plainText argument is null of empty");
		} else {
			byte[] bytes = plainText.getBytes(StandardCharsets.UTF_8);
			Base64.Encoder encoder = Base64.getEncoder();
			byte[] encodedBytes = encoder.encode(bytes);
			return new String(encodedBytes, StandardCharsets.UTF_8);
		}
	}

	public static String decodeBase64(String encodedText) {
		if (isEmpty(encodedText)) {
			throw new IllegalArgumentException("encodedText argument is null of empty");
		} else {
			byte[] bytes = encodedText.getBytes(StandardCharsets.UTF_8);
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] decodedBytes = decoder.decode(bytes);
			return new String(decodedBytes, StandardCharsets.UTF_8);
		}
	}

	public static String getConcatenationPath(String path1, String path2, @NonNull String separator) {
		if (separator == null) {
			throw new NullPointerException("separator is marked non-null but is null");
		} else {
			String result = null;
			path1 = org.apache.commons.lang3.StringUtils.defaultString(path1, "");
			path2 = org.apache.commons.lang3.StringUtils.defaultString(path2, "");
			if (path1.endsWith(separator)) {
				result = String.format("%s%s", path1, path2);
			} else {
				result = String.format("%s%s%s", path1, separator, path2);
			}

			return result;
		}
	}

	public static String getConcatenationPath(String path1, String path2) {
		return getConcatenationPath(path1, path2, System.getProperty("file.separator"));
	}

	public static String getConcatenationPathForImg(String path1, String path2) {
		return getConcatenationPath(path1, path2, "/");
	}
}