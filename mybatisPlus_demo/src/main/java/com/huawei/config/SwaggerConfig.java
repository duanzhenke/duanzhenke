package com.huawei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
public class SwaggerConfig {
    @Bean
    public Docket getDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .groupName("段震科")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huawei.controller"))
                .build();
        return docket;
    }

    @Bean
    public Docket getDocketA() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
        return docket;
    }
    @Bean
    public Docket getDocketB() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("B");
        return docket;
    }



    private ApiInfo getApiInfo() {
        // 作者的信息
        Contact contact = new Contact("段震科","www.baidu.com","1830123765@qq.com");
        return new ApiInfo("段震科的Swagger测试日记",
                "2020-07-19  段震科 Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
