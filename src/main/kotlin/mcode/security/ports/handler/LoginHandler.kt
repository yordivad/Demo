package mcode.security.ports.handler

import mcode.security.domain.service.IdentityService
import org.omg.CORBA.ServerRequest
import org.springframework.context.annotation.Configuration

@Configuration
class LoginHandler(val identityService: IdentityService) {

    fun authenticate(request: ServerRequest) {
        //identityService.authenticate(request)
    }

}