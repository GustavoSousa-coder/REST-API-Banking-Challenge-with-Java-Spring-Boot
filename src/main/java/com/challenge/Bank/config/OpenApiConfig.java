package com.challenge.Bank.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Application for banking transactions and statistics search")
                        .version("v1")
                        .description("With this application, it is possible to manipulate data like in a bank transaction and retrieve your statistics for a customized time period.")
                );
    }

}
