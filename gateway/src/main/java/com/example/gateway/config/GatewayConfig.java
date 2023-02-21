package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/user")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("lb://user-service"))
                .route(p -> p
                        .path("/product")
//                        .filters(f -> f.circuitBreaker(config -> config.setName("mycmd")))
                        .uri("lb://product-service")).
                build();
    }
}
