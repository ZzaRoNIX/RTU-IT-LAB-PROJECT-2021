package com.saprikin.labprojekt.repository

import com.saprikin.labprojekt.entity.Cheque
import org.springframework.data.jpa.repository.JpaRepository

interface ChequeRepository : JpaRepository<Cheque?,Int?> {

}