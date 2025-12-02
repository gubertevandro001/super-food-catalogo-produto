package com.superfood.catalogo_produto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("super-food-catalogo-produto-api")
                        .description("API para gerenciar o catálogo de produtos do ERP Super Food")
                        .version("1.0.0"));
    }
}