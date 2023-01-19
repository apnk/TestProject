package com.test.project.testproject.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.validator.constraints.pl.PESEL

@Entity
@Table(name = "account")
class Account (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "second_name")
    val secondName: String,

    @PESEL
    @Column(name = "pesel")
    val pesel: String,

    @OneToMany()
    val subAccounts: List<SubAccount> = listOf()
)
