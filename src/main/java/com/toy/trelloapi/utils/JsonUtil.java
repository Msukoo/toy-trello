package com.toy.trelloapi.utils;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final ObjectReader reader;

	private JsonUtil() {
	}

	public static ObjectMapper getObjectMapper() {
		return mapper;
	}

	public static String toJsonString(Object value) {
		return toJsonString(value, false);
	}

	public static String toJsonString(Object value, boolean isPrettyFormat) {
		if (value == null) {
			return null;
		} else {
			ObjectWriter writer = mapper.writer();
			if (isPrettyFormat) {
				writer = mapper.writerWithDefaultPrettyPrinter();
			}

			String jsonStr = null;

			try {
				jsonStr = writer.writeValueAsString(value);
			} catch (JsonProcessingException var5) {
				log.warn(".toJsonString(Object,boolean): Convert error (Object -> JSON String).", var5);
			}

			return jsonStr;
		}
	}

	public static <T> T toObject(JsonNode jsonNode, Class<T> objectType) {
		Object object = null;

		try {
			object = reader.treeToValue(jsonNode, objectType);
		} catch (JsonProcessingException var4) {
			log.warn(".toObject(JsonNode,Class<T>): Convert error (JSON -> Object).", var4);
		}

		return (T) object;
	}

	public static <T> T toObject(JsonNode jsonNode, TypeReference<T> typeRef) {
		Object object = null;

		try {
			object = mapper.readerFor(typeRef).readValue(jsonNode);
		} catch (IOException var4) {
			log.warn(".toObject(JsonNode,TypeReference<T>): Convert error (JSON -> Object).", var4);
		}

		return (T) object;
	}

	public static JavaType toJavaType(Type type) {
		return mapper.getTypeFactory().constructType(type);
	}

	public static <T> T toObject(String jsonString, Type type) {
		Object object = null;

		try {
			object = mapper.readerFor(toJavaType(type)).readValue(jsonString);
		} catch (JsonProcessingException var4) {
			log.warn(".toObject(JsonNode,Type): Convert error (JSON -> Object).", var4);
		}

		return (T) object;
	}

	public static <T> T toObject(String jsonString, JavaType javaType) {
		Object object = null;

		try {
			object = mapper.readerFor(javaType).readValue(jsonString);
		} catch (JsonProcessingException var4) {
			log.warn(".toObject(JsonNode,JavaType): Convert error (JSON -> Object).", var4);
		}

		return (T) object;
	}

	public static <T> T toObject(String jsonString, Class<T> objectType) {
		Object object = null;

		try {
			object = mapper.readerFor(objectType).readValue(jsonString);
		} catch (JsonProcessingException var4) {
			log.warn(".toObject(JsonNode,Class<T>): Convert error (JSON -> Object).", var4);
		}

		return (T) object;
	}

	public static <T> T toObject(String jsonString, TypeReference<T> typeReference) {
		Object value = null;

		try {
			value = mapper.readerFor(typeReference).readValue(jsonString);
		} catch (JsonProcessingException var4) {
			log.warn(".toObject(String,TypeReference<T>): Convert error (JSON -> Object).", var4);
		}

		return (T) value;
	}

	public static <T> T toObject(byte[] bytes, Class<T> objectType) {
		Object value = null;

		try {
			value = mapper.readerFor(objectType).readValue(bytes);
		} catch (IOException var4) {
			log.warn(".toObject(byte[],Class<T>): Convert error (JSON -> Object).", var4);
		}

		return (T) value;
	}

	public static <T> T toObject(InputStream inputStream, Class<T> objectType) {
		Object value = null;

		try {
			value = mapper.readerFor(objectType).readValue(inputStream);
		} catch (IOException var4) {
			log.warn(".toObject(InputStream,Class<T>): Convert error (JSON -> Object).", var4);
		}

		return (T) value;
	}

	public static JsonNode toJsonNode(String jsonString) {
		try {
			return reader.readTree(jsonString);
		} catch (JsonProcessingException var2) {
			log.error("Parsing error. (source=" + jsonString + ")", var2);
			return NullNode.instance;
		}
	}

	public static boolean isNullOrMissingNode(JsonNode node) {
		return node == null || NullNode.instance.equals(node) || node.isMissingNode();
	}

	public static JsonNode valueToTree(Object value) {
		return mapper.valueToTree(value);
	}

	public static JsonNode toJsonNode(InputStream inputStream) {
		JsonNode node = null;

		try {
			node = reader.readTree(inputStream);
		} catch (IOException var3) {
			log.warn(" > toJsonNode() :: Convert error (InputStream -> JsonNode).", var3);
		}

		return node;
	}

	public static <T> T getValueOfPath(JsonNode parentNode, String path) {
		if (parentNode == null) {
			return null;
		} else {
			JsonNode node = parentNode.at(path);
			return !node.isMissingNode() && !node.isNull() ? toObject(node, new TypeReference<T>() {
			}) : null;
		}
	}

	public static JsonNode setValueToPath(JsonNode rootNode, String path, Object value) {
		Map.Entry<String, ObjectNode> entry = getParentNodeAndFieldName(rootNode, path);
		if (entry == null) {
			throw new IllegalArgumentException("Cannot find JsonNode for path(" + path + ")");
		} else {
			ObjectNode parentNode = (ObjectNode)entry.getValue();
			String fieldName = (String)entry.getKey();
			parentNode.set(fieldName, valueToTree(value));
			return parentNode.get(fieldName);
		}
	}

	private static Map.Entry<String, ObjectNode> getParentNodeAndFieldName(JsonNode rootNode, String path) {
		JsonPointer valueNodePointer = JsonPointer.compile(path);
		JsonPointer containerPointer = valueNodePointer.head();
		JsonNode parentJsonNode = rootNode.at(containerPointer);
		if (!parentJsonNode.isMissingNode() && parentJsonNode.isObject()) {
			ObjectNode parentObjectNode = (ObjectNode)parentJsonNode;
			String fieldName = valueNodePointer.last().toString();
			fieldName = fieldName.replace(Character.toString('/'), "");
			JsonNode fieldValueNode = parentObjectNode.get(fieldName);
			if (fieldValueNode != null) {
				return new AbstractMap.SimpleEntry(fieldName, parentObjectNode);
			}
		}

		return null;
	}

	static {
		reader = mapper.reader();
	}
}

