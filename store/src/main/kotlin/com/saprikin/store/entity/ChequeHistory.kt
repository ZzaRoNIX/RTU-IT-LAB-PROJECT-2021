package com.saprikin.store.entity

import com.saprikin.store.enum.PaymentMethod
import java.util.*
import javax.persistence.*

@Entity
class ChequeHistory(
    var paymentMethod: PaymentMethod?,
    var memberId : Int?,
    var memberName: String?,
    var storeId: Int?,
    var category: String?,@OneToMany(mappedBy = "date", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var productHistory: List<ProductHistory>
) {


    @Id
    var date = Date()




}