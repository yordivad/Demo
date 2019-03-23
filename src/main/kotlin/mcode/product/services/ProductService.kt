package mcode.product.services

import mcode.product.model.Product
import reactor.core.publisher.Mono

interface ProductService {
    fun getProduct(id: Int): Mono<Product>
    fun createProduct(product: Mono<Product>): Mono<Product>
    fun deleteProduct(id: Int)
    fun updateProduct(id: Int, product: Product)
    fun searchProduct(filter: String): List<Product>
}