package com.test.project.testproject.data.repository

import com.test.project.testproject.data.entity.Account
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {

    @EntityGraph(attributePaths = ["subAccounts"])
    fun findByPesel(pesel: String) : Account?

}