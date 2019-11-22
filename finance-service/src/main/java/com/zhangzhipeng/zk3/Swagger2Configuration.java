package com.zhangzhipeng.zk3;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Configuration {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("api").select().apis(RequestHandlerSelectors.basePackage("com.zhangzhipeng.zk3.controller")).paths(PathSelectors.any()).build().apiInfo(new ApiInfoBuilder().title("Swagger测试哦").build());
    }


}
