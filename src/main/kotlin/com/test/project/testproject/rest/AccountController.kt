package com.test.project.testproject.rest

import com.test.project.testproject.data.mapper.toAccountResponse
import com.test.project.testproject.data.mapper.toCreateAccountResponse
import com.test.project.testproject.data.request.CreateAccountRequest
import com.test.project.testproject.data.request.ExchangeMoneyRequest
import com.test.project.testproject.data.response.AccountResponse
import com.test.project.testproject.data.response.CreateAccountResponse
import com.test.project.testproject.logic.AccountService
import com.test.project.testproject.logic.enums.Exchange
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController (
    private val accountService: AccountService
){

    @Transactional
    @PostMapping("/accounts/create")
    fun createAccount(
        @Valid @RequestBody request: CreateAccountRequest
    ) : CreateAccountResponse {
        return accountService.createNewAccount(
            name = request.name,
            secondName = request.secondName,
            pesel = request.pesel,
            initialAmount = request.initialAmount
        ).toCreateAccountResponse()
    }

    @GetMapping("/accounts/{pesel}")
    fun getAccount(
        @PathVariable pesel: String
    ): AccountResponse {
        return accountService.getAccount(
            pesel = pesel
        ).toAccountResponse()
    }

    @Transactional
    @PostMapping("/accounts/{pesel}/exchange")
    fun exchangeMoney(
        @PathVariable pesel: String,
        @Valid @RequestBody request: ExchangeMoneyRequest
    ): AccountResponse {
        return accountService.exchangeMoney(
            pesel = pesel,
            exchange = Exchange.valueOf(request.exchange),
            amount = request.amount
        ).toAccountResponse()
    }


}

