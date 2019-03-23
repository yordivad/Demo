package mcode.product.model

import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "Product")
data class  Product(var id:Int = 0, val name: String)