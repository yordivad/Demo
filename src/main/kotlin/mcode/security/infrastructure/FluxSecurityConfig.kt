package mcode.security.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User

@Configuration
@EnableWebFluxSecurity
class FluxSecurityConfig {



    @Bean
    fun securityFilterChain(http: ServerHttpSecurity) =
            http.authorizeExchange()
                    .pathMatchers("/login", "/logout").permitAll()
                    .anyExchange().authenticated()
                    .and()

                    .httpBasic()
                    .and().build()


}