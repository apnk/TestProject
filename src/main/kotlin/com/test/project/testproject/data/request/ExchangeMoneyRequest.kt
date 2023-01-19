package com.test.project.testproject.data.request

import jakarta.validation.constraints.Positive
import java.math.BigDecimal

class ExchangeMoneyRequest (
    val exchange: String,
    @field:Positive
    val amount: BigDecimal
)