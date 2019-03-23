package mcode.product.services.implementation

import mcode.product.model.Product
import mcode.product.repository.ProductRepository
import mcode.product.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ProductServiceImpl : ProductService {

    @Autowired
    private lateinit var repository: ProductRepository

    override fun getProduct(id: Int) : Mono<Product> = repository.findById(id)


    override fun createProduct(product: Mono<Product>) = repository.create(product)


    override fun deleteProduct(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateProduct(id: Int, product: Product) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchProduct(filter: String): List<Product> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}