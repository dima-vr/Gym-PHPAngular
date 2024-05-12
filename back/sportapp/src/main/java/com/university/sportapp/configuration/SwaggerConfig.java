package com.university.sportapp.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Actual")
                .pathsToMatch("/**")
                .addOpenApiCustomiser(customerGlobalHeaderOpenApiCustomiser())
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Web API")
                        .version("v1")
                        .license(
                                new License().name("Apache 2.0")
                                        .url("http://springdoc.org")));
    }

    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> openApi.getPaths().values().forEach(pathItem -> {
            this.addDefaultDeleteResponse(pathItem.getDelete());
            this.addDefaultPostResponse(pathItem.getPost());
        });
    }

    private void addDefaultDeleteResponse(Operation operation) {
        if (operation == null) {
            return;
        }
        ApiResponses apiResponses = operation.getResponses();

        Content nonFoundContent = new Content().addMediaType(APPLICATION_JSON_VALUE, new MediaType());
        ApiResponse nonFoundResponce = new ApiResponse()
                .description("Requested resource not found")
                .content(nonFoundContent);
        apiResponses.addApiResponse("404", nonFoundResponce);

        Content unauthorizedContent = new Content().addMediaType(APPLICATION_JSON_VALUE, new MediaType());
        ApiResponse unauthorizedResponse = new ApiResponse()
                .description("Unauthorized")
                .content(unauthorizedContent);
        apiResponses.addApiResponse("401", unauthorizedResponse);
    }

    private void addDefaultPostResponse(Operation operation) {
        if (operation == null) {
            return;
        }
        ApiResponses apiResponses = operation.getResponses();

        Content badRequestContent = new Content().addMediaType(APPLICATION_JSON_VALUE, new MediaType());
        ApiResponse badRequestResponce = new ApiResponse()
                .description("Bad request")
                .content(badRequestContent);
        apiResponses.addApiResponse("400", badRequestResponce);

        Content unauthorizedContent = new Content().addMediaType(APPLICATION_JSON_VALUE, new MediaType());
        ApiResponse unauthorizedResponse = new ApiResponse()
                .description("Unauthorized")
                .content(unauthorizedContent);
        apiResponses.addApiResponse("401", unauthorizedResponse);
    }
}