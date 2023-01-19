package com.test.project.testproject.data.request

import java.math.BigDecimal
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.pl.PESEL

data class CreateAccountRequest (
    val name: String,
    val secondName: String,
    @field:PESEL
    val pesel: String,
    @field:Positive
    val initialAmount: BigDecimal
)