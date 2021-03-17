package com.saprikin.store.repository

import com.saprikin.store.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store,Int> {
    fun existsByName(name: String?): Boolean
}