package mcode.security.domain.service

import mcode.security.domain.message.AuthRequest
import mcode.security.domain.message.AuthResponse
import mcode.security.domain.model.Identity
import mcode.security.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Service
class IdentityService : ReactiveUserDetailsService {

    @Autowired
    lateinit var identityRepository: UserRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    lateinit var token: TokenService

    /**
     * Find the [UserDetails] by username.
     * @param username the username to look up
     * @return the [UserDetails]. Cannot be null
     */
    override fun findByUsername(username: String): Mono<UserDetails> =
            identityRepository.findByUserName(username).map { it.toIdentity() }


    fun authenticated(auth: Mono<AuthRequest>): Mono<AuthResponse> =
            auth.flatMap { user ->
                this.findByUsername(user.user).flatMap {
                    if (passwordEncoder.matches(user.password , it.password))
                        AuthResponse(token.generateToken(it as Identity)).toMono()
                    else Mono.empty()
                }
            }
}