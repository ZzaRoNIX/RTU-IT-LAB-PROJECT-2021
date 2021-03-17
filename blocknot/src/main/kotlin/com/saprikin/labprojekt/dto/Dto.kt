package com.saprikin.labprojekt.dto

import com.saprikin.store.enum.PaymentMethod


class Dto (var productHistory: List<DtoRows>,
           var paymentMethod: PaymentMethod,
           var memberName: String,
           var memberId: Int,
           var category: String,
           var storeId: Int){

}