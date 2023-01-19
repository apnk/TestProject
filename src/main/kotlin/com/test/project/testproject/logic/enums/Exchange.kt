package com.test.project.testproject.logic.enums

import com.test.project.testproject.logic.component.PLNToUSDExchangeLogic
import com.test.project.testproject.logic.component.USDToPLNExchangeLogic
import kotlin.reflect.KClass

enum class Exchange (
    val exchangeLogicClass: KClass<*>,
    val sourceCurrency: CurrencyCode,
    val targetCurrencyCode: CurrencyCode
){
    USD_TO_PLN(USDToPLNExchangeLogic::class, CurrencyCode.USD, CurrencyCode.PLN),
    PLN_TO_USD(PLNToUSDExchangeLogic::class, CurrencyCode.PLN, CurrencyCode.USD)
}