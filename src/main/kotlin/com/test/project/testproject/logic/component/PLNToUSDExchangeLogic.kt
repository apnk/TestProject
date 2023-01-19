package com.test.project.testproject.logic.component

import com.test.project.testproject.logic.helper.ExchangeHelper
import java.math.BigDecimal
import java.math.RoundingMode
import org.springframework.stereotype.Component

@Component
class PLNToUSDExchangeLogic (
    private val exchangeHelper: ExchangeHelper
): ExchangeLogic {

    override fun exchange(amount: BigDecimal): BigDecimal {
        val exchangeRate = exchangeHelper.getUSDExchangeRate().rates.first()
        return amount.divide(exchangeRate.bid, 2, RoundingMode.HALF_UP)
    }

}