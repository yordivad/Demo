package mcode.security.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class PasswordEncoderConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder =
            object : PasswordEncoder {
                override fun encode(rawPassword: CharSequence?): String =
                        BCryptPasswordEncoder().encode(rawPassword)

                override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean =
                        BCryptPasswordEncoder().matches(rawPassword, encodedPassword)
            }
}