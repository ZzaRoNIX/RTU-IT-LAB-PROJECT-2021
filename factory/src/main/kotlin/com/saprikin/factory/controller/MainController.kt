package com.saprikin.factory.controller

import com.saprikin.factory.entity.Production
import com.saprikin.factory.repository.ProductionRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(private var productionRepository: ProductionRepository){
    @PostMapping("/addProduction")
    fun addPositions(@RequestBody production: ArrayList<Production>) {
        productionRepository.saveAll(production)
    }
}
