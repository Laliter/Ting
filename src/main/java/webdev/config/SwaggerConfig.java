package webdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by dell on 2016-11-29.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .enable(true)
                .apiInfo(demoApiInfo());
    }

    private ApiInfo demoApiInfo() {
        ApiInfo apiInfo = new ApiInfo("某API接口",//大标题
                "REST风格API",//小标题
                "0.1",//版本
                "www.baidu.com",
                new Contact("Test",null,null),
                "主页",//链接显示文字
                ""//网站链接
        );
        return apiInfo;
    }
}
