package com.saprikin.store.repository

import com.saprikin.store.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {
    fun findAllByStoreId(shopId: Int?): List<Product?>?
    fun findByProductNameAndStoreId(productName: String?, storeId: Int?): Product?

}