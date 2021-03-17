package com.saprikin.vpn

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.http.HttpServletRequest

class Filter : ZuulFilter() {
    private val log: Logger = LoggerFactory.getLogger(Filter::class.java)

    override fun filterType(): String? {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 1
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun run(): Any? {
        val ctx: RequestContext = RequestContext.getCurrentContext()
        val request: HttpServletRequest = ctx.getRequest()
        log.info(String.format("%s request to %s", request.method, request.requestURL.toString()))
        return null
    }
}