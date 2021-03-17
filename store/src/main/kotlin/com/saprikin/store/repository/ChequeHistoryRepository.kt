package com.saprikin.store.repository

import com.saprikin.store.entity.ChequeHistory
import org.springframework.data.jpa.repository.JpaRepository

interface ChequeHistoryRepository : JpaRepository<ChequeHistory, Int> {
}