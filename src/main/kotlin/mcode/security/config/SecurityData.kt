package mcode.security.config

import mcode.security.domain.model.User
import mcode.security.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import reactor.core.publisher.toMono

import javax.annotation.PostConstruct

@Component
class SecurityData {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var operations: ReactiveMongoOperations

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @PostConstruct
    fun init() {
        operations.collectionExists("users").subscribe {
            if (it != true) {
                operations.createCollection("Users").subscribe {
                    userRepository.save(User("roy", passwordEncoder.encode("123")).toMono()).subscribe {
                        println("user created")
                    }
                }
            }
        }
    }
}