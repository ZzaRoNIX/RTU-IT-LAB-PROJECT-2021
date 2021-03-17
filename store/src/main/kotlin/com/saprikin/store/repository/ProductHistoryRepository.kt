package com.saprikin.store.repository

import com.saprikin.store.entity.ProductHistory
import org.springframework.data.jpa.repository.JpaRepository

interface ProductHistoryRepository : JpaRepository<ProductHistory, Int> {
}