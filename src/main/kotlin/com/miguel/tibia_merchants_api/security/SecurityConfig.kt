package com.miguel.tibia_merchants_api.security

import com.miguel.tibia_merchants_api.utils.Environment
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebFluxSecurity
class SecurityConfig: Environment() {
    @Value("\${tibia.merchants.secret}")
    lateinit var secret: String
    @Value("\${tibia.merchants.pathToken}")
    lateinit var pathToken: String
    @Value("\${tibia.merchants.paths}")
    lateinit var paths:String

    @Bean
    fun securityConf() = SecurityConf(secret = environment("secret", secret) ?: secret)

    @Bean
    fun jwtFilter() = JwtFilter(securityConf())

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        http.csrf { it.disable() }
            .authorizeExchange {
                it.pathMatchers(pathToken).permitAll()
                it.pathMatchers(paths)
                    .authenticated()//.hasAuthority("ROLE_USER") // endpoint para generar token externo
                it.anyExchange().authenticated()
            }
            .addFilterAt(jwtFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
        return http.build()
    }
}