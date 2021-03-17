package com.saprikin.store.entity

import javax.persistence.*

@Entity
class Store(
    var name: String?,
    var address: String?,
    var phoneNumber: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null


    @OneToMany(mappedBy = "storeId", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var productSet: Set<Product>? = null
}