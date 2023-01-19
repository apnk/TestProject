package com.test.project.testproject.data.response

import java.math.BigDecimal

data class AccountResponse(
    val name: String,
    val secondName: String,
    val pesel: String,
    val subAccounts: List<SubAccountResponse>
) {
    class SubAccountResponse(
        val currency: String,
        val amount: BigDecimal
    )
}
