package mcode.security.ports.handler

import mcode.security.domain.service.IdentityService

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

import org.springframework.web.reactive.function.server.bodyToMono

@Component
class AuthHandler(val identity: IdentityService) {

    fun authenticate(request: ServerRequest) =
            identity.authenticated(request.bodyToMono()).flatMap { ok().body(fromObject(it)) }


}