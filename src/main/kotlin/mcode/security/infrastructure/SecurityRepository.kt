package mcode.security.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextImpl
import org.springframework.security.web.server.context.ServerSecurityContextRepository
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class SecurityRepository : ServerSecurityContextRepository {

    @Autowired
    lateinit var auth : AuthenticationManager


    /**
     * Saves the SecurityContext
     * @param exchange the exchange to associate to the SecurityContext
     * @param context the SecurityContext to save
     * @return a completion notification (success or error)
     */
    override fun save(exchange: ServerWebExchange?, context: SecurityContext?): Mono<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Loads the SecurityContext associated with the [ServerWebExchange]
     * @param exchange the exchange to look up the [SecurityContext]
     * @return the [SecurityContext] to lookup or empty if not found. Never null
     */
    override fun load(exchange: ServerWebExchange): Mono<SecurityContext> {
        val request = exchange.request
        val authHeader = request.headers.getFirst(HttpHeaders.AUTHORIZATION)
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val authToken = authHeader.substring(7)
            val token = UsernamePasswordAuthenticationToken(authToken, authToken)
            return this.auth.authenticate(token).map { SecurityContextImpl(it) }
        }
        return Mono.empty()
    }


}