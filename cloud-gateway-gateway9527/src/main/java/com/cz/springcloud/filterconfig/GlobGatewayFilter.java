package com.cz.springcloud.filterconfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;


@Component
//@Slf4j
public class GlobGatewayFilter implements GlobalFilter, Ordered {

//可以定义多个自定义filter实现上面的2个接口，可以实现多个过滤器，然后用下面的getOrder方法的数字来控制先走哪一个。

    //这个方法可以作为操作日志的记录，记录请求参数和方法名称然后入库等。
    //或者作为全局的token验证的地方也可以。
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //log.info("*********come in MyLogGateWayFilter: "+new Date());
        System.out.println("*********come in MyLogGateWayFilter: "+new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(StringUtils.isEmpty(username)){
            //log.info("*****用户名为Null 非法用户,(┬＿┬)");
            System.out.println("*****用户名为Null 非法用户,(┬＿┬)");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//给人家一个回应
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }





    @Override
    public int getOrder() {
        return 0;   //数字越小这个过滤器就会越优先执行，0是最小，所以会第一个执行这个过滤器
    }
}
