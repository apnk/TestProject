package com.test.project.testproject.data.response

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class NBPUSDExchangeResponse (
    @JsonProperty("table")
    val table: String,

    @JsonProperty("currency")
    val currency: String,

    @JsonProperty("code")
    val code: String,

    @JsonProperty("rates")
    val rates: List<Rates>
) {
    class Rates (
        @JsonProperty("no")
        val no: String,
        @JsonProperty("effectiveDate")
        val effectiveDate: String,
        @JsonProperty("bid")
        val bid: BigDecimal,
        @JsonProperty("ask")
        val ask: BigDecimal
    )
}