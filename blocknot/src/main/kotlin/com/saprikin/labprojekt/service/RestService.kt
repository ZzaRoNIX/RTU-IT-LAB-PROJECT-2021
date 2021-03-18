package com.saprikin.labprojekt.service


import com.google.gson.Gson
import com.google.gson.GsonBuilder

import com.saprikin.labprojekt.dto.Dto
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RestService(private val restTemplate: RestTemplate) {

    var gson: Gson = GsonBuilder().create()


    fun postBuy(dto: Dto): Dto? {
        val payLoadStr = gson.toJson(dto)
        val headers = HttpHeaders()
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers.contentType = MediaType.APPLICATION_JSON
        headers["path"] = payLoadStr
        val requestBody: HttpEntity<Dto> = HttpEntity<Dto>(dto, headers)
        val responseEntity: ResponseEntity<Dto> = restTemplate.exchange(
            "http://localhost:8082/buy",
            HttpMethod.POST,
            requestBody,
            Dto::class.java
        )
        return responseEntity.body
    }
}