package com.fastcampus.deliveryapi.config

import com.fastcampus.deliveryapi.domain.customer.CustomerRole
import com.fastcampus.deliveryapi.security.CustomAccessDeniedHandler
import com.fastcampus.deliveryapi.security.CustomAuthenticationEntryPoint
import com.fastcampus.deliveryapi.security.JwtAuthenticationFilter
import com.fastcampus.deliveryapi.security.JwtExceptionFilter
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationProvider: AuthenticationProvider,
    private val objectMapper: ObjectMapper,
) {
    @Bean
    fun securityFilterChain(
        http: HttpSecurity,
        jwtAuthenticationFilter: JwtAuthenticationFilter,
        jwtExceptionFilter: JwtExceptionFilter,
    ): DefaultSecurityFilterChain {
        http
            .cors { it.configurationSource(corsConfigurationSource()) }
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it
                    .requestMatchers(
                        "/hello",
                        "/apis/auth",
                        "/apis/auth/refresh",
                        "/error",
                        "/apis/customer/signup",
                        "/apis/categories/**",
                        "/apis/stores/**", "/apis/home/**",
                        "/apis/display/**",
                        "/apis/search",
                        "/apis/geocode"
                    )
                    .permitAll()
                    .requestMatchers("/apis/customer/**")
                    .hasRole(CustomerRole.CUSTOMER.name)
                    .anyRequest()
                    .fullyAuthenticated()
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .exceptionHandling { it.accessDeniedHandler(CustomAccessDeniedHandler()) }
            .exceptionHandling { it.authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper)) }
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration().applyPermitDefaultValues()
        configuration.allowedHeaders = listOf("*")
        configuration.allowedOrigins = listOf("http://localhost:8080", "http://localhost:20001")
        configuration.allowedMethods = listOf("*")
        configuration.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}