package com.saprikin.factory.entity

import javax.persistence.Entity
import javax.persistence.Id
@Entity
class WareHouse(@Id
                var productName: String?,
                var storeId: Int?,
                var price : Int?,
                var category: String?,
                var quantity: Int?) {
}