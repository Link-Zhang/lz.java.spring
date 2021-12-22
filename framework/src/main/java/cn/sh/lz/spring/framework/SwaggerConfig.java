package cn.sh.lz.spring.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Link at 14:55 on 2021/12/22.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder().scope("read").description("read access").build();
        SecurityReference securityReference = SecurityReference.builder().reference("framework").scopes(authScopes).build();
        ArrayList<SecurityContext> securityContexts = newArrayList(SecurityContext.builder().securityReferences(newArrayList(securityReference)).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new BasicAuth("framework")))
                .securityContexts(securityContexts)
                .groupName("server-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.sh.lz.spring.framework.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Restful API")
                .version("1.0.0.RELEASE")
                .contact(new Contact("Link Zhang", "", "Link.Zhang.0@gmail.com"))
                .build();
    }
}
