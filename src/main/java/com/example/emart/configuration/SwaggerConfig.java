package com.example.emart.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI springBlogPessoalOpenApi() {
        return new OpenAPI()
                .info(new Info().title("EMART")
                        .description("Back-end de um sistema de E-commerce, um projeto pessoal.")
                        .version("v0.0.1")
                        .license(new License().name("Emart"))
                        .contact(new Contact().name("Artur Figueiredo")
                                .email("emart-es@outlook.com")))
                .externalDocs(new ExternalDocumentation().description("Github")
                        .url("https://www.github.com/EMART-ES"))
                .externalDocs(new ExternalDocumentation().description("Instagram")
                        .url("https://www.instagram.com/emart_roupasoficial/"));

    }

    @Bean
    OpenApiCustomizer customizerGlobalHeaderOpenApiCustomizer() {

        return openApi -> openApi.getPaths().values()
                .forEach(pathItem -> pathItem.readOperations()
                        .forEach(operation -> {
                            ApiResponses apiResponses = operation.getResponses();

                            apiResponses.addApiResponse("200", new ApiResponse().description("Sucesso!"));
                            apiResponses.addApiResponse("201", new ApiResponse().description("Objeto persistido!"));
                            apiResponses.addApiResponse("204", new ApiResponse().description("Objeto excluido!"));
                            apiResponses.addApiResponse("400", new ApiResponse().description("Erro na requisição!"));
                            apiResponses.addApiResponse("401", new ApiResponse().description("Acesso não autorizado!"));
                            apiResponses.addApiResponse("403", new ApiResponse().description("Acesso Proibido!"));
                            apiResponses.addApiResponse("404", new ApiResponse().description("Objeto não encontrado!"));
                            apiResponses.addApiResponse("500", new ApiResponse().description("Erro na aplicação!"));
                        }));
    }
}