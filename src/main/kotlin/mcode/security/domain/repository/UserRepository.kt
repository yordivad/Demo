package mcode.security.domain.repository

import mcode.security.domain.model.User
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono


@Repository
class UserRepository (val template: ReactiveMongoTemplate) {
    fun findByUserName(name: String) : Mono<User> =
            this.template.findOne(Query.query(Criteria.where("user").`is`(name)), User::class.java)
}