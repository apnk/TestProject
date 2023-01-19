package com.test.project.testproject.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "sub_account")
class SubAccount (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "currency")
    val currency: String,

    @Column(name = "amount")
    var amount: BigDecimal
)