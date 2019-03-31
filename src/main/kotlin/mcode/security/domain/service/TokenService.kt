package mcode.security.domain.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import mcode.security.domain.model.Identity
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec

@Service
class TokenService {
    @Value("\${mcode.token.secret}")
    lateinit var secret: String

    @Value("\${mcode.token.expiration}")
    lateinit var expirationDate: String



    fun getAllClaimsFrommToken(token: String) =
      Jwts.parser()
              .setSigningKey(Base64.getEncoder().encodeToString(this.secret.toByteArray()))
              .parseClaimsJws(token).body

    fun getUserNameFromToken(token: String) = this.getAllClaimsFrommToken(token).subject

    fun getExpirationDateFromToken(token: String) = this.getAllClaimsFrommToken(token).expiration

    fun isTokenExpired(token: String): Boolean = getExpirationDateFromToken(token).before(Date())

    fun generateToken(identinty: Identity) : String {
        var claims = HashMap<String, Any >()
        val createdDate = Date()
        val expirationDate = Date(createdDate.time + this.expirationDate.toLong() * 1000 )
        return Jwts.builder().setClaims(claims)
                .setSubject(identinty.username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(secret.toByteArray()) , SignatureAlgorithm.HS512)
                .compact()
    }

    fun validateToken(token :String) = !this.isTokenExpired(token)

}