package mcode.security.domain.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Users")
class User(var name: String, var email: String, var password: String) {

    var nonExpire: Boolean = true
    var enable: Boolean = false
    var nonLocked: Boolean = true
    var credentialsNonExpire: Boolean = false

    constructor( name: String,  password: String): this(name,"",password)

    constructor(user: User) : this(user.name, user.email, user.password) {
        nonExpire = user.nonExpire
        enable = user.enable
        nonLocked = user.nonLocked
        credentialsNonExpire = user.credentialsNonExpire
    }

    fun toIdentity() : Identity = Identity(user = this)
}