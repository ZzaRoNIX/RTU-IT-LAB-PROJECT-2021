package com.saprikin.labprojekt.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Product(
    var chequeId: Int,


    var productName: String,


    var price: Int,


    var quantity: Int
) {


    @Id
    private val created = Date()
}