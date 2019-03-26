package mcode.security.domain.service

import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import java.io.*;

@Service
class TokenService {
    @Value("mcode.token.secret")
    lateinit var secret: String

    @Value("mcode.token.expiration")
    lateinit var expirationDate: String
    https://medium.com/@ard333/authentication-and-authorization-using-jwt-on-spring-webflux-29b81f813e78

    fun getAllClaimsFrommToken(token: String) =
      Jwts.parser()
              .setSigningKey(Base64.getEncoder().encodeToString(this.secret.toByteArray()))
              .parseClaimsJws(token).body

}