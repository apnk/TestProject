package com.test.project.testproject.logic.component

import java.math.BigDecimal

interface ExchangeLogic {
    fun exchange(amount: BigDecimal): BigDecimal
}