package com.saprikin.labprojekt.controller

import com.google.gson.GsonBuilder
import com.saprikin.labprojekt.dto.Dto
import com.saprikin.labprojekt.entity.Cheque
import com.saprikin.labprojekt.entity.Member
import com.saprikin.labprojekt.entity.Product
import com.saprikin.labprojekt.repository.ChequeRepository
import com.saprikin.labprojekt.repository.MemberRepository
import com.saprikin.labprojekt.repository.ProductRepository
import com.saprikin.labprojekt.service.RestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpStatusCodeException

@RestController
class MainController @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val restService: RestService,
    private val chequeRepository: ChequeRepository,
    private val productRepository: ProductRepository
) {


    @PostMapping("/addUser")
    fun addUser(@RequestParam name: String?): ResponseEntity<String?>? {
        return if (!memberRepository.existsByMemberName(name)) {
            memberRepository.save(Member(name))
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.status(400).body("Пользователь с таким именем уже есть")
        }
    }

    @GetMapping("/getUser")
    fun getUser(@RequestParam id: Int): ResponseEntity<String?>? {
        val gson = GsonBuilder().create()
        val payloadStr = gson.toJson(memberRepository.findById(id))
        return ResponseEntity(payloadStr, HttpStatus.OK)
    }

    @PostMapping("/buy")
    fun buy(@RequestBody dto: Dto): ResponseEntity<*>? {
        var fullPrice = 0
        if (!memberRepository.existsByMemberName(dto.memberName)) {
            return ResponseEntity.status(401).build<Any>()
        }
        try {
            val cheque: Dto? = restService.postBuy(dto)

            if (cheque != null) {
                for (price in cheque.productHistory!!) {
                    fullPrice += price.price!!

                }
            }

            if (cheque != null) {
                var chequeId: Int? = chequeRepository.save(
                    Cheque(
                        category = cheque.category,
                        memberId = cheque.memberId,
                        fullPrice = fullPrice,
                        storeId = dto.storeId,
                        memberName = dto.memberName
                    )
                ).chequeId
                for (row in cheque.productHistory) {
                    chequeId?.let {
                        row.productName?.let { it1 ->
                            row.price?.let { it2 ->
                                row.quantity?.let { it3 ->
                                    Product(
                                        it, it1,
                                        it2, it3
                                    )
                                }
                            }
                        }
                    }?.let {
                        productRepository.save(
                            it
                        )
                    }
                }
            }
        } catch (exception: HttpStatusCodeException) {
            return ResponseEntity<Any>(exception.statusCode)
        }
        return ResponseEntity.ok().build<Any>()
    }
}