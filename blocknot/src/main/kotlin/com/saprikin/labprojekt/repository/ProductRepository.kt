package com.saprikin.labprojekt.repository

import com.saprikin.labprojekt.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product?, Int?> {
}