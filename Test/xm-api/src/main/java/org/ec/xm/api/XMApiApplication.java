package org.ec.xm.api;

import org.ec.attachment.service.impl.AttachmentServiceImplConfiguration;
import org.ec.global.EcGlobalConfiguration;
import org.ec.utils.EcUtilsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@SpringBootApplication(scanBasePackages = {"org.ec.xm"})
// 分别引入工具库， 业务全局库， 附件库
@Import({EcUtilsConfiguration.class, EcGlobalConfiguration.class, AttachmentServiceImplConfiguration.class})
@EnableSwagger2
public class XMApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XMApiApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {
        // swagger 扫描MH的api
        Predicate<RequestHandler> mhSelector = RequestHandlerSelectors.basePackage("org.ec.xm.api")::apply;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(mhSelector::test)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xm api")
                .description("xm API工具")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
