package com.test.project.testproject.data.mapper

import com.test.project.testproject.data.entity.Account
import com.test.project.testproject.data.response.AccountResponse
import com.test.project.testproject.data.response.CreateAccountResponse

fun Account.toCreateAccountResponse(): CreateAccountResponse {
    return CreateAccountResponse(
        accountId = this.id
    )
}

fun Account.toAccountResponse(): AccountResponse {
    return AccountResponse(
        name = this.name,
        secondName = this.secondName,
        pesel = this.pesel,
        subAccounts = this.subAccounts.map {subAccount ->
            AccountResponse.SubAccountResponse(
                currency = subAccount.currency,
                amount = subAccount.amount
            )
        }
    )
}