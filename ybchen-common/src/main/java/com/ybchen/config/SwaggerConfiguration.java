package com.ybchen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置
 *
 * @author: chenyanbin 2022-10-21 15:46
 */
@Component
@EnableOpenApi
public class SwaggerConfiguration {
    /**
     * 根据部署环境，觉得是否开启swagger，建议线上环境，关闭！！！
     */
    private Boolean enable = true;

    @Value("${spring.application.name}")
    private String serviceName;

    /**
     * 接口文档
     *
     * @return
     */
    @Bean
    public Docket webApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("微服务接口文档")
                .pathMapping("/")
                //定义是否开启Swagger
                .enable(enable)
                //配置文档元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ybchen.controller"))
                //正则匹配请求路径，并分配到当前项目组
                .paths(PathSelectors.ant("/api/**"))
                .build()
                //新版Swagger3.0配置
                //请求参数
                .globalRequestParameters(globalRequestParamters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("分布式事务")
                .description("微服务名：" + serviceName)
                .contact(new Contact("陈彦斌", "https://www.cnblogs.com/chenyanbin/", "qq:543210188"))
                .version("v1.0")
                .build();
    }

    /**
     * 配置全局通用参数
     *
     * @return
     */
    private List<RequestParameter> globalRequestParamters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                //参数名称
                .name("token")
                //描述
                .description("登录令牌")
                //类型，Header
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                //是否必须
                .required(false)
                .build());
        return parameters;
    }
}