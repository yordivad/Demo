package mcode.security.ports

import mcode.security.ports.handler.AuthHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class AuthRouter(private val auth : AuthHandler) {

    @Bean
    fun authRoutes() = router {

        "/login".nest {
            POST("/", auth::authenticate)
        }

    }
}