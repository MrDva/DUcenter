package com.itchenyang.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        InetSocketAddress localAddress = exchange.getRequest().getRemoteAddress();
        System.out.println(localAddress);
        System.out.println(username);
        System.out.println("hello");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
