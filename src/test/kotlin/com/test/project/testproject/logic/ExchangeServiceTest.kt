package com.test.project.testproject.logic

import com.test.project.testproject.data.response.NBPUSDExchangeResponse
import com.test.project.testproject.logic.enums.Exchange
import com.test.project.testproject.logic.helper.ExchangeHelper
import java.math.BigDecimal
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class ExchangeServiceTest {

    @Autowired
    lateinit var exchangeService: ExchangeService

    @MockBean
    lateinit var exchangeHelper: ExchangeHelper

    @BeforeEach
    fun setUp() {
        Mockito.`when`(exchangeHelper.getUSDExchangeRate()).thenReturn(NBPUSDExchangeResponse(
            table = "C",
            currency = "USD",
            code = "",
            rates = listOf(
                NBPUSDExchangeResponse.Rates(
                    no = "",
                    effectiveDate = "",
                    bid = BigDecimal.valueOf(4.24),
                    ask = BigDecimal.valueOf(4.33)
                )
            )
        ))
    }

    @Test
    fun usdToPlnTest() {
        val response = exchangeService.exchange(Exchange.USD_TO_PLN, BigDecimal.TWO)
        Assertions.assertEquals(BigDecimal.valueOf(8.66), response)
    }

    @Test
    fun plnToUsdTest() {
        val response = exchangeService.exchange(Exchange.PLN_TO_USD, BigDecimal.TEN)
        Assertions.assertEquals(BigDecimal.valueOf(2.36), response)
    }

}