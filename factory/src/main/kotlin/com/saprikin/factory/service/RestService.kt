package com.saprikin.factory.service


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.saprikin.factory.dto.Dto
import com.saprikin.factory.entity.WareHouse
import com.saprikin.factory.repository.WareHouseRepository


import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RestService(private val restTemplate: RestTemplate, private var wareHouseRepository: WareHouseRepository) {
    var wareHouseList: ArrayList<WareHouse> = ArrayList<WareHouse>()
    var gson: Gson = GsonBuilder().create()


    fun postProduction(dto: ArrayList<Dto>) {
        val payLoadStr = gson.toJson(dto)
        val headers = HttpHeaders()
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        headers.contentType = MediaType.APPLICATION_JSON
        headers["path"] = payLoadStr
        val requestBody: HttpEntity<ArrayList<Dto>> = HttpEntity<ArrayList<Dto>>(dto, headers)
        try {

            val responseEntity: ResponseEntity<Dto> = restTemplate.exchange(
                    "http://localhost:8082/addProduct",
                    HttpMethod.POST,
                    requestBody,
                    Dto::class.java
            )
            wareHouseRepository.deleteAll()
        } catch (e: Exception) {
            for (dto1 in dto) {
                val duplicate: WareHouse? = wareHouseRepository.findByProductNameAndStoreId(dto1.productName, dto1.storeId)
                if (duplicate != null) {
                    duplicate.quantity = duplicate.quantity?.plus(dto1.quantity)

                    wareHouseRepository.save(
                            duplicate
                    )

                } else {
                    wareHouseList.add(
                            WareHouse(
                                    category = dto1.category,
                                    productName = dto1.productName,
                                    quantity = dto1.quantity,
                                    storeId = dto1.storeId,
                                    price = dto1.price
                            )
                    )
                    wareHouseRepository.saveAll(wareHouseList)
                }


            }

        }
    }
}