package com.saprikin.factory.repository

import com.saprikin.factory.entity.WareHouse
import org.springframework.data.jpa.repository.JpaRepository

interface WareHouseRepository : JpaRepository<WareHouse, Int> {
    fun findByProductNameAndStoreId(name:String?,storeId:Int):WareHouse?
}