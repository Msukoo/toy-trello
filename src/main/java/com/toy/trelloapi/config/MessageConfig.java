package com.toy.trelloapi.config;

import com.toy.trelloapi.constant.ConfigKeys;
import com.toy.trelloapi.constant.Delimiters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

@Slf4j
@Configuration
public class MessageConfig {
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.KOREA);

		return localeResolver;
	}

	@Value("${" + ConfigKeys.KEY_ERROR_MESSAGE_PROPERTY_BASE_DIR + ":#{null}}")
	private String baseDir;

	@Value("${" + ConfigKeys.KEY_MESSAGES_PROPERTY_BASE_DIR + ":#{null}}")
	private String messageBaseDir;

	@Value("${" + ConfigKeys.KEY_RESPONSE_MESSAGES_PROPERTY_BASE_DIR + ":#{null}}")
	private String responseMessageBaseDir;

	@Bean(name = "errorMessageProperties")
	public Properties errorMessageProperties() {
		Properties errorProperties = new Properties();

		if (!StringUtils.hasText(baseDir)) {
			log.debug("Base URI is null. Set default value.");
			baseDir = "/error";
		}//end: if

		String classpathDir = baseDir.substring(1);

		List<String> errorFileNames = new ArrayList<>();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		try {
			Resource[] resources = resolver.getResources(ConfigKeys.CLASSPATH + classpathDir + Delimiters.SLASH + Delimiters.ASTERISK);
			for (Resource resource: resources) {
				errorFileNames.add(resource.getFilename());
			}//end: for-loop
		} catch (IOException e) {
			log.warn(".errorMessageProperties(): ResourcePatternResolver", e);
		}//end: try-catch

		YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
		try {
			for (String fileName : errorFileNames) {

				List<PropertySource<?>> propertySourceList = loader.load(fileName, new ClassPathResource(classpathDir + Delimiters.SLASH + fileName));
				for (PropertySource<?> propertySource : propertySourceList) {
					log.debug(".errorMessageProperties(): propertySourceList > propertySource = {}", propertySource);
					OriginTrackedMapPropertySource mapPropertySource = (OriginTrackedMapPropertySource) propertySource;
					String[] propertyNames = mapPropertySource.getPropertyNames();
					for(String propertyName : propertyNames) {
						String value = mapPropertySource.getProperty(propertyName).toString();
						errorProperties.put(propertyName, value);
					}
				}
			}
		} catch (IOException e) {
			log.warn(".errorMessageProperties(): YamlPropertySourceLoader", e);
		}//end: try-catch

		log.info(" > Error Properties = {}", errorProperties);
		return errorProperties;
	}//end: errorMessageProperties()

	@Bean(name = "messageProperties")
	public Properties messageProperties() {

		Properties messageProperties = new Properties();

		if (!StringUtils.hasText(messageBaseDir)) {
			log.debug("Base URI is null. Set default value.");
			messageBaseDir = "/messages";
		}//end: if

		String classpathDir = messageBaseDir.substring(1);

		List<String> messageFileNames = new ArrayList<>();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		try {
			String msgPropertiesPath = ConfigKeys.CLASSPATH + classpathDir + Delimiters.SLASH + Delimiters.ASTERISK;
			log.info("Load MessageProperties from path : {}", msgPropertiesPath);
			Resource[] resources = resolver.getResources(msgPropertiesPath);
			for (Resource resource: resources) {
				messageFileNames.add(resource.getFilename());
			}//end: for-loop
		} catch (IOException e) {
			log.warn(".messageProperties(): ResourcePatternResolver", e);
		}//end: try-catch

		YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
		try {
			for (String fileName : messageFileNames) {

				List<PropertySource<?>> propertySourceList = loader.load(fileName, new ClassPathResource(classpathDir + Delimiters.SLASH + fileName));
				for (PropertySource<?> propertySource : propertySourceList) {
					log.debug(".messageProperties(): propertySourceList > propertySource = {}", propertySource);
					OriginTrackedMapPropertySource mapPropertySource = (OriginTrackedMapPropertySource) propertySource;
					String[] propertyNames = mapPropertySource.getPropertyNames();
					for(String propertyName : propertyNames) {
						String value = mapPropertySource.getProperty(propertyName).toString();
						messageProperties.put(propertyName, value);
					}
				}
			}
		} catch (IOException e) {
			log.warn(".messageProperties(): YamlPropertySourceLoader", e);
		}

		log.info(" > Messages Properties = {}", messageProperties);
		return messageProperties;
	}

	@Bean(name = "responseMessageProperties")
	public Properties responseMessageProperties() {

		Properties responseMessageProperties = new Properties();

		if (!StringUtils.hasText(responseMessageBaseDir)) {
			log.debug("Base URI is null. Set default value.");
			responseMessageBaseDir = "/response";
		}//end: if

		String classpathDir = responseMessageBaseDir.substring(1);

		List<String> messageFileNames = new ArrayList<>();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
		try {
			String msgPropertiesPath = ConfigKeys.CLASSPATH + classpathDir + Delimiters.SLASH + Delimiters.ASTERISK;
			log.info("Load MessageProperties from path : {}", msgPropertiesPath);
			Resource[] resources = resolver.getResources(msgPropertiesPath);
			for (Resource resource: resources) {
				messageFileNames.add(resource.getFilename());
			}//end: for-loop
		} catch (IOException e) {
			log.warn(".responseMessageProperties(): ResourcePatternResolver", e);
		}//end: try-catch

		YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
		try {
			for (String fileName : messageFileNames) {

				List<PropertySource<?>> propertySourceList = loader.load(fileName, new ClassPathResource(classpathDir + Delimiters.SLASH + fileName));
				for (PropertySource<?> propertySource : propertySourceList) {
					log.debug(".messageProperties(): propertySourceList > propertySource = {}", propertySource);
					OriginTrackedMapPropertySource mapPropertySource = (OriginTrackedMapPropertySource) propertySource;
					String[] propertyNames = mapPropertySource.getPropertyNames();
					for(String propertyName : propertyNames) {
						String value = mapPropertySource.getProperty(propertyName).toString();
						responseMessageProperties.put(propertyName, value);
					}
				}
			}
		} catch (IOException e) {
			log.warn(".responseMessageProperties(): YamlPropertySourceLoader", e);
		}

		log.info(" > response Properties = {}", responseMessageProperties);
		return responseMessageProperties;
	}

}