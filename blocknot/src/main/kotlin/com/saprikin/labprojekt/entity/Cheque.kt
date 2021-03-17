package com.saprikin.labprojekt.entity

import java.util.*
import javax.persistence.*

@Entity
class Cheque(
    var memberId: Int,
    var storeId: Int,
    var category: String,
    var fullPrice: Int, memberName: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var chequeId: Int? = null


    var date = Date()

    @OneToMany(mappedBy = "created", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var products: List<Product>? = null
}