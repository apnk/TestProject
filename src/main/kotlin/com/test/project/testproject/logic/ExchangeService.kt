package com.test.project.testproject.logic

import com.test.project.testproject.logic.component.ExchangeLogic
import com.test.project.testproject.logic.enums.Exchange
import java.math.BigDecimal
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class ExchangeService(
    private val applicationContext: ApplicationContext,
) {

    fun exchange(exchange: Exchange, amount: BigDecimal): BigDecimal {
        return getExchange(exchange).exchange(amount)
    }

    private fun getExchange(exchange: Exchange): ExchangeLogic {
        return applicationContext.getBean(exchange.exchangeLogicClass.java) as ExchangeLogic
    }


}