package mcode.security.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity


@Configuration
@EnableWebFluxSecurity
class FluxSecurityConfig {


    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var securityRepository : SecurityRepository

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity) =
            http.csrf().disable()
                    .formLogin().disable()
                    .httpBasic().disable()
                    .authenticationManager(authenticationManager)
                    .securityContextRepository(securityRepository)
                    .authorizeExchange()
                    .pathMatchers(HttpMethod.OPTIONS).permitAll()
                    .pathMatchers("/login", "/logout").permitAll()
                    .anyExchange().authenticated()
                    .and().build()
}