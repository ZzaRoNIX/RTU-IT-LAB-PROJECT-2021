package com.saprikin.labprojekt.entity

import javax.persistence.*

@Entity
class Member(var memberName: String?) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @OneToMany(mappedBy = "memberId", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var chequeSet: List<Cheque>? = null


}
