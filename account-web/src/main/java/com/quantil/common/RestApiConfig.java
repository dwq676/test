package com.quantil.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * RestApiConfig
 *
 * @author <a href="mailto:wenqing.dai@quantil.com">daiwenqing</a>
 * @date 2017/3/21
 */

    /*
     * Restful API 访问路径:
     * http://IP:port/{context-path}/swagger-ui.html
     * eg:http://localhost:8080/jd-config-web/swagger-ui.html
     */
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.quantil"})
@Configuration
public class RestApiConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                //.pathMapping("/api/0.1/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.quantil"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Account APIs")
                .termsOfServiceUrl("")
                .contact("QUANTIL,INC.")
                .version("0.1")
                .build();
    }
}
