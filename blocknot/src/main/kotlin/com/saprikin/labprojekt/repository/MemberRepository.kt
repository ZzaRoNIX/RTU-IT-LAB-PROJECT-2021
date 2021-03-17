package com.saprikin.labprojekt.repository

import com.saprikin.labprojekt.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member?,Int> {
    fun existsByMemberName(Name: String?): Boolean
}