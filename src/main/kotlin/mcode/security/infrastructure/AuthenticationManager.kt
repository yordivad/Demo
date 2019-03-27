package mcode.security.infrastructure

import mcode.security.domain.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Component
class AuthenticationManager : ReactiveAuthenticationManager {

    @Autowired
    lateinit var tokenService: TokenService

    /**
     * Attempts to authenticate the provided [Authentication]
     *
     * @param authentication the [Authentication] to test
     * @return if authentication is successful an [Authentication] is returned. If
     * authentication cannot be determined, an empty Mono is returned. If authentication
     * fails, a Mono error is returned.
     */
    override fun authenticate(authentication: Authentication): Mono<Authentication> {
       val token = authentication.credentials.toString()
        val user = tokenService.getUserNameFromToken(token)
       return UsernamePasswordAuthenticationToken (user, null, null).toMono()
    }

}