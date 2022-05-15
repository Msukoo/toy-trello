package com.toy.trelloapi.config;

import com.fasterxml.classmate.TypeResolver;
import com.toy.trelloapi.message.ErrorMessage;
import com.toy.trelloapi.message.ErrorMessageGuide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.title:trello API}")
    private String title;

    @Value("${swagger.description: trello API Docs}")
    private String description;

    @Value("${swagger.version: 1.0}")
    private String version;

    /*@Value("${swagger.terms-of-sevice-url: http://}")
    private String termsOfServiceUrl;*/

    @Value("${swagger.protocols: https}")
    private String[] protocols;

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket restAPI() {
        List<ResponseMessage> responseMessages = createGloblaResponseMessage();
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(new HashSet<>(Arrays.asList(protocols)))
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                .additionalModels(typeResolver.resolve(ErrorMessage.class),
                                  typeResolver.resolve(ErrorMessageGuide.Response400Guide.class),
                                  typeResolver.resolve(ErrorMessageGuide.Response401Guide.class))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.toy.trelloapi"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                /*.termsOfServiceUrl(termsOfServiceUrl)*/
                .build();
                /*.title("Trello Spring Boot REST API")
                .version("1.0.0")
                .description("Trello swagger api")
                .build();*/
    }

    /**
     * Create Global ResponseMessage
     *
     * @author trello
     * @return List<ResponseMessage>
     */
    private List<ResponseMessage> createGloblaResponseMessage() {
        ModelRef errorModel = new ModelRef("ErrorMessage");
        ModelRef error400Model = new ModelRef("Response400Guide");
        ModelRef error401Model = new ModelRef("Response401Guide");
        return Arrays.asList(
            new ResponseMessageBuilder().code(400).message("Bad Request").responseModel(error400Model).build(),
            new ResponseMessageBuilder().code(401).message("Unauthorized").responseModel(error401Model).build(),
            new ResponseMessageBuilder().code(500).message("Internal Server Error").responseModel(errorModel).build());
    }
}
