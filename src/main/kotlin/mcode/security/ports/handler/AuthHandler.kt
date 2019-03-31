package mcode.security.ports.handler

import mcode.security.domain.message.AuthRequest
import mcode.security.domain.message.AuthResponse
import mcode.security.domain.model.Identity
import mcode.security.domain.model.User
import mcode.security.domain.service.IdentityService
import mcode.security.domain.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyExtractor
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono

@Configuration
class AuthHandler(val identityService: IdentityService) {

    @Autowired
    lateinit var identity: IdentityService

    fun authenticate(request: ServerRequest) =
            ServerResponse.ok().body(fromObject(identity.authenticated(request.bodyToMono<AuthRequest>())))


}