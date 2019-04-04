package mcode.security.config

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono


@Component
class CorsFilter : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        exchange.response.headers.add("Access-Control-Allow-Origin", "*")
        exchange.response.headers.add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS")
        exchange.response.headers.add("Access-Control-Allow-Headers", "*")
        if(exchange.request.method == HttpMethod.OPTIONS) {
            exchange.response.headers.add("Access-Control-Max-Age", "1728000")
            exchange.response.statusCode = HttpStatus.OK
            return Mono.empty()
        }
        return chain.filter(exchange)
    }

}