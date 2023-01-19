package com.test.project.testproject.data.repository

import com.test.project.testproject.data.entity.SubAccount
import org.springframework.data.jpa.repository.JpaRepository

interface SubAccountRepository: JpaRepository<SubAccount, Long>