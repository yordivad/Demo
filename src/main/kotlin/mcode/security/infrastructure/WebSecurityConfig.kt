package mcode.security.infrastructure

import mcode.security.domain.service.IdentityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var identityService: IdentityService

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.sessionManagement().disable()
        http.authorizeRequests()
                .antMatchers("/api/*").authenticated()
                .anyRequest().permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(identityService)
                .passwordEncoder(passwordEncoder)
    }

}