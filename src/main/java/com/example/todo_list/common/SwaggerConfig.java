package com.example.todo_list.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = { @Server(url = "http://yhtodo-env.eba-etyrmp7y.ap-northeast-2.elasticbeanstalk.com/"),
        @Server(url = "http://localhost:8080/")})
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1-definition")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("유현 투두리스트 api")
                        .description("토이 프로젝트 투두리스트 API 입니다.")
                        .version("v0.0.1"));

    }


}