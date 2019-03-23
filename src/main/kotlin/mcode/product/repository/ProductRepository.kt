package mcode.product.repository

import mcode.product.model.Product
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class ProductRepository(private val template: ReactiveMongoTemplate) {
    fun create(product: Mono<Product>) = template.save(product)
    fun findById(id: Int) : Mono<Product> = template.findById(id)
}
