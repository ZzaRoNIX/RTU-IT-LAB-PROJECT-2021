package com.saprikin.vpn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean

@EnableZuulProxy
@SpringBootApplication
class VpnApplication {

    @Bean
    fun filter(): Filter? {
        return Filter()
    }
}

fun main(args: Array<String>) {
    runApplication<VpnApplication>(*args)
}