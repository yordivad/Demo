package mcode.security.domain.service

import mcode.security.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ReactiveIdentityService : ReactiveUserDetailsService {

    @Autowired
    lateinit var identityRepository: UserRepository

    /**
     * Find the [UserDetails] by username.
     * @param username the username to look up
     * @return the [UserDetails]. Cannot be null
     */
    override fun findByUsername(username: String): Mono<UserDetails> =
            identityRepository.findByUserName(username).map { it.toIdentity() }

}