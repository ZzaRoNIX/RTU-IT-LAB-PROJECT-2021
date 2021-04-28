package com.saprikin.factory.service

import com.saprikin.factory.dto.Dto
import com.saprikin.factory.entity.Production
import com.saprikin.factory.entity.WareHouse
import com.saprikin.factory.repository.ProductionRepository
import com.saprikin.factory.repository.WareHouseRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service


@Service
class SchedulerService(
    private var wareHouseRepository: WareHouseRepository,
    private var productionRepository: ProductionRepository,
    private val restService: RestService
) {

    var dto: ArrayList<Dto> = ArrayList<Dto>()


    @Scheduled(initialDelayString = "3000", fixedDelayString = "3000")
    @Throws(InterruptedException::class)
    fun doWork() {
        var productions: MutableList<Production> = productionRepository.findAll()

        for (production in productions) {
            dto.add(
                Dto(
                    productName = production.productName,
                    storeId = production.storeId,
                    category = production.category,
                    quantity = production.quantity,
                    price = production.price
                )
            )
        }
        if (wareHouseRepository.findAll().isEmpty()) {
            restService.postProduction(dto)

        } else {

            val wareHouseProductions: MutableList<WareHouse> = wareHouseRepository.findAll()
            for (production in wareHouseProductions) {
                production.category?.let {
                    production.productName?.let { it1 ->
                        production.quantity?.let { it2 ->
                            production.storeId?.let { it3 ->
                                production.price?.let { it4 ->
                                    Dto(
                                        category = it,
                                        productName = it1,
                                        quantity = it2,
                                        storeId = it3,
                                        price = it4
                                    )
                                }
                            }
                        }
                    }
                }?.let {
                    dto.add(
                        it
                    )
                }
            }
            restService.postProduction(dto)

        }
        // wareHouseRepository.deleteAll()

    }


}


