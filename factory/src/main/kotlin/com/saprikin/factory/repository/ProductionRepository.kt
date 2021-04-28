package com.saprikin.factory.repository

import com.saprikin.factory.entity.Production
import org.springframework.data.jpa.repository.JpaRepository

interface ProductionRepository : JpaRepository<Production, Int> {

}