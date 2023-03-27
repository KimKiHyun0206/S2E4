package com.projeckt.s2e4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.OAS_30)
                .ignoredParameterTypes(
                        HttpServletRequest.class
                )
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.projeckt.s2e4"))
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("S2E4 api info")
                .description("Basic API")
                .version("1.0.0")
                .build();
    }
}