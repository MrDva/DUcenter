package com.itchenyang.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    //    给/admin/.*开头的url，分组为adminApi
    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")    // 分组管理
                .apiInfo(adminApiInfo())   // 为分组创建基本信息
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    public ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("喜庆宝后台管理系统API文档")
                .description("描述了后台管理系统的各个模块的接口调用方式")
                .contact(new Contact("ChenYang","http://cjkcare.top","1151094976@qq.com"))
                .version("1.1")
                .build();
    }

    //    给/web/.*开头的url，分组为webApi
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")    // 分组管理
                .apiInfo(webApiInfo())  // 为分组创建基本信息
                .select()
                .paths(Predicates.and(PathSelectors.regex("/web/.*")))
                .build();
    }

    public ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("喜庆宝用户网站管理系统API文档")
                .description("描述了用户管理系统的各个模块的接口调用方式")
                .contact(new Contact("ChenYang","http://cjkcare.top","1151094976@qq.com"))
                .version("1.1")
                .build();
    }
}
