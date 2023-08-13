package no.hamre.springboot.springdoc.springdoclatest

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.security.SecuritySchemes
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	info = Info(title = "Somerthing"),
	servers = [
		Server(url = "url", description = "decr", )
	],
	security = [
		SecurityRequirement(name = "basicAuth"),
		SecurityRequirement(name = "bearerToken")
	]
)
@SecuritySchemes(
	SecurityScheme(
		name = "basicAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "basic"
	),
	SecurityScheme(
		name = "bearerToken",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT"
	)
)
class SpringdocLatestApplication

fun main(args: Array<String>) {
	runApplication<SpringdocLatestApplication>(*args)
}
