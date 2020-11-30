package com.besti.swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jack Pan
 * @version 1.0 2020/11/28
 */
@Configuration
@EnableSwagger2   //开启Swagger2
public class swaggerConfig {


   //配置swagger的Docketbean实例
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .groupName("Hello")
                //enable是否启动swagger，如果为false，则swagger不能再浏览器中访问
                .enable(true)
                .select()
                //指定要扫描的包，RequestHandlerSelectors.basePackage():指定要扫描的包
                //               RequestHandlerSelectors.any():扫描全部
                //               RequestHandlerSelectors.none():不扫描
                //               RequestHandlerSelectors.withClassAnnotation():扫描类上的注解
                //               RequestHandlerSelectors.withMethodAnnotation():扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.besti.swaggerdemo.controller"))
                .paths(PathSelectors.any())  //过滤路径
                .build();
    }

    //配置swagger信息=apiInfo
    private ApiInfo getApiInfo(){

        Contact contact = new Contact("jackpan","https://github.com/jackpancode","2471072530@qq.com");

        return new ApiInfoBuilder()
                .title("jack的Swagger2文档")
                .description("Swagger2")
                .version("1.0")
                .license("Apache 2.0")
                .contact(contact)
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
