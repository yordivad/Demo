package mcode.security.ports

import mcode.security.ports.handler.AuthHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class AuthRouter(private val auth : AuthHandler) {

    @Bean
    fun authRoutes() = router {
        "/login".nest {
            POST("/", auth::authenticate)
        }
    }
}