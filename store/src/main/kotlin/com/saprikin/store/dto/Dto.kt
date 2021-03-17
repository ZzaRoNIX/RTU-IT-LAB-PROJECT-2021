package com.saprikin.labprojekt.dto

import com.saprikin.store.dto.DtoRows
import com.saprikin.store.enum.PaymentMethod


class Dto (
){
    lateinit var productHistory: List<DtoRows>
    lateinit var paymentMethod: PaymentMethod
    lateinit var memberName: String
    var memberId: Int = 0
    lateinit var category: String
    var storeId: Int = 0

}