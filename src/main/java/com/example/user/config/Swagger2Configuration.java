package com.example.user.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Swagger2 配置2.7.0
 *
 * @author Leaves
 * @version 1.0.0
 * @date 2017/11/21
 */
@EnableSwagger2
@Configuration
public class Swagger2Configuration {

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.user.web"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
//                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class,
                        typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                        typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)

//                //Allows globally overriding response messages for different http methods. In this example we override the 500 error code for all `GET`s
//                .globalResponseMessage(RequestMethod.GET,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("500 message")
//                                .responseModel(new ModelRef("Error"))
//                                .build()))

                //Sets up the security schemes used to protect the apis. Supported schemes are ApiKey, BasicAuth and OAuth Provides a way to globally set up security contexts for operation.
                .securitySchemes(newArrayList(apiKey()))
                .securityContexts(newArrayList(securityContext()))

                //As a result we could distinguish paths that have the same path stem but different query string combinations.
                .enableUrlTemplating(false)

//                //Allows globally configuration of default path-/request-/headerparameters which are common for every rest operation of the api, but aren`t needed in spring controller method signature (for example authenticaton information). Parameters added here will be part of every API Operation in the generated swagger specification.
//                .globalOperationParameters(newArrayList(new ParameterBuilder()
//                                .name("someGlobalParameter")
//                                .description("Description of someGlobalParameter")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("query")
//                                .required(false)
//                                .build()))

//                .tags(new Tag("", ""))
//                .additionalModels(typeResolver.resolve(AdditionalModel.class))
                ;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("引用三组", "http://www.senthink.com", "lingcy@senthink.com");
        return new ApiInfo("Challenger-smart",
                "这是一个数据库增删改查的测试",
                "1.0.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }

    private ApiKey apiKey() {
        return new ApiKey("mykey", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("mykey", authorizationScopes));
    }

//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                "test-app-client-id",
//                "test-app-client-secret",
//                "test-app-realm",
//                "test-app",
//                "",
//                ApiKeyVehicle.HEADER,
//                "mykey",
//                ",");
//    }

//    @Bean
//    UiConfiguration uiConfig() {
//        return new UiConfiguration(
//                // url
//                "validatorUrl",
//                // docExpansion => none | list
//                "none",
//                // apiSorter => alpha
//                "alpha",
//                // defaultModelRendering => schema
//                "schema",
//                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
//                // enableJsonEditor => true | false
//                false,
//                // showRequestHeaders => true | false
//                true,
//                // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
//                60000L);
//    }
}