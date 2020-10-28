package demo.springboot.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author 熊雨翔
 * @Date 2020/10/28 15:22
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // URL：http://localhost:8080/doc.html#/

    @Bean
    public Docket myDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SpringBoot Demo API")   // 标题
                .description("SpringBoot Demo Swagger[Api接口文档]")    // 描述
                .contact(new Contact("InorySnow", "", "xiongyuxiang1996@163.com"))  // 联系方式
                .version("1.0") // 版本号
                .build();

        return docket
                .apiInfo(apiInfo)
                // 设置只生成被Api这个注解注解过的Ctrl类中有ApiOperation注解的api接口的文档
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }
}
