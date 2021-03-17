package com.saprikin.store.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ProductHistory(
    @Id
    var productName: String?,
    var price: Int?,
    var quantity: Int?,

) {
    var date: Date? = Date()

}