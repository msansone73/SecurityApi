package br.com.msansone.securityapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecurityApiApplication

fun main(args: Array<String>) {
	runApplication<SecurityApiApplication>(*args)
}
