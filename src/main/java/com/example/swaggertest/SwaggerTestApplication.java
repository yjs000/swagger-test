package com.example.swaggertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class SwaggerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerTestApplication.class, args);
	}

    @Bean
    public Docket helloApi() {
        return new Docket(DocumentationType.SWAGGER_2) //swagger 2로 설정 //swagger1, 2, openApi 3.0 이 있음
                .groupName("hello-api") //없으면 default
                .select() //세밀하게 설정할 수 있도록 하는 ApiSelectorBuilder를 반환
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggertest.helloController")) //하위의 api를 가져옴
                .paths(PathSelectors.any()) // 허용할 path들 Any, regex, ant, any, none가능
                .build();
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2) //swagger 2로 설정 //swagger1, 2, openApi 3.0 이 있음
                .groupName("test-api") //없으면 default
                .select() //세밀하게 설정할 수 있도록 하는 ApiSelectorBuilder를 반환
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggertest.testController")) //하위의 api를 가져옴
                .paths(PathSelectors.any()) // 허용할 path들 Any, regex, ant, any, none가능
                .build();
    }
}
