package mcode.product.web

import mcode.product.command.ProductHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class ProductRouter(private val productHandler: ProductHandler) {
    @Bean
    fun productRoutes() = router {
        "/product".nest {
            GET("/{id}", productHandler::get)
            POST("/", productHandler::create)
        }
    }
}