package com.example.servicegateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean

@EnableEurekaClient
@SpringBootApplication
class ServiceGatewayApplication {
	@Bean
	fun myRoutes(builder: RouteLocatorBuilder): RouteLocator = builder
		.routes().route { p -> p
			.path("/product/**")
			.filters{ f -> f.addRequestHeader("Hello", "Servant")}
			.uri("http://localhost:8721")}
		.build()
}

fun main(args: Array<String>) {
	runApplication<ServiceGatewayApplication>(*args)
}
