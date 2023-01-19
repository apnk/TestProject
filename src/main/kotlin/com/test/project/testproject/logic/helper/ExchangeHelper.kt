package com.test.project.testproject.logic.helper

import com.test.project.testproject.data.exceptions.NotFoundException
import com.test.project.testproject.data.response.NBPUSDExchangeResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ExchangeHelper (
    @Value("\${nbp.usd.exchangerate.url}") private val usdExchangeUrl: String
) {

    /**
     * Na potrzeby zadania zakładam strzał po kurs za każdym razem bo
     * nie wiem co ile te dane się zmeiniają ale produkcyjnie pewnie
     * dałoby się to jakoś cachować, dodatko nbp zwraca wartości ask
     * i bid. Zakładam, że jedna jest do sprzedaży druga do kupowania
     * waluty (nie znalazłem dokładnego opisu)
     */
    fun getUSDExchangeRate(): NBPUSDExchangeResponse {
        return RestTemplate().getForObject(
            usdExchangeUrl,
            NBPUSDExchangeResponse::class.java
        )?: throw NotFoundException("Cannot find exchange rate")
    }

}