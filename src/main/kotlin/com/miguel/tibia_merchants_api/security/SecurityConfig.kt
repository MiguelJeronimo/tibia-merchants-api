package com.miguel.tibia_merchants_api.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebFluxSecurity
class SecurityConfig {
    @Value("\${tibia.merchants.secret}")
    lateinit var secret: String
    @Value("\${tibia.merchants.pathToken}")
    lateinit var pathToken: String
    @Value("\${tibia.merchants.paths}")
    lateinit var paths:String

    @Bean
    fun securityConf() = SecurityConf(secret = secret)

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