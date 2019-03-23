package mcode.product

import mcode.product.command.ProductHandler
import mcode.product.web.ProductRouter
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductTest {


    @Autowired
    lateinit var productHandler: ProductHandler

    @Test
    fun `get product should be success`() {

        val client = WebTestClient.bindToRouterFunction (ProductRouter(productHandler).productRoutes()).build()
        client.get().uri("/product/10")
                .exchange()
                .expectStatus()
                .isOk


    }


}