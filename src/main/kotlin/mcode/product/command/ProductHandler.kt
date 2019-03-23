package mcode.product.command

import mcode.product.services.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity.created
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import java.net.URI


@Component
class ProductHandler(val productService: ProductService) {
    fun get(request: ServerRequest) =
            productService
                    .getProduct(request.pathVariable("id").toInt())
                    .flatMap { p -> ServerResponse.ok().body(fromObject(p)) }
                    .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).build())

    fun create(request: ServerRequest) =
            productService.createProduct(request.bodyToMono())
                    .flatMap { ServerResponse.created(URI.create("/customer/${it.id}")).build() }

}