package com.saprikin.store.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Product(
    @Id
    var productName: String?,
    var storeId: Int?,
    var price: Int?,
    var category: String?,
    var quantity: Int?
) {


}