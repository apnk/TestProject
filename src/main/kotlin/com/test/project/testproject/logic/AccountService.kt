package com.test.project.testproject.logic

import com.test.project.testproject.data.entity.Account
import com.test.project.testproject.data.entity.SubAccount
import com.test.project.testproject.data.exceptions.NotFoundException
import com.test.project.testproject.data.repository.AccountRepository
import com.test.project.testproject.data.repository.SubAccountRepository
import com.test.project.testproject.logic.enums.CurrencyCode
import com.test.project.testproject.logic.enums.Exchange
import com.test.project.testproject.logic.helper.PeselHelper
import java.math.BigDecimal
import org.springframework.stereotype.Component


@Component
class AccountService(
    private val accountRepository: AccountRepository,
    private val subAccountRepository: SubAccountRepository,
    private val exchangeService: ExchangeService
) {

    fun createNewAccount(name: String, secondName: String, pesel: String, initialAmount: BigDecimal): Account {
        verifyPesel(pesel)
        val plnSubAccount = subAccountRepository.save(
            SubAccount(
                amount = initialAmount,
                currency = CurrencyCode.PLN.code
            )
        )
        val enSubAccount = subAccountRepository.save(
            SubAccount(
                amount = BigDecimal.ZERO,
                currency = CurrencyCode.USD.code
            )
        )
        return accountRepository.save(
            Account(
                name = name,
                secondName = secondName,
                pesel = pesel,
                subAccounts = listOf(plnSubAccount, enSubAccount)
            )
        )
    }

    fun exchangeMoney(pesel: String, exchange: Exchange, amount: BigDecimal): Account {
        val account = getAccount(pesel = pesel)

        val sourceAccount = account.subAccounts.find { it.currency == exchange.sourceCurrency.code }?: throw NotFoundException("Cannot find subaccount for ${exchange.sourceCurrency.code} ")
        val targetAccount = account.subAccounts.find { it.currency == exchange.targetCurrencyCode.code }?: throw NotFoundException("Cannot find subaccount for ${exchange.targetCurrencyCode.code} ")

        if (sourceAccount.amount < amount) {
            throw IllegalStateException("Not enough funds on source account")
        }

        val exchangeResult = exchangeService.exchange(exchange = exchange, amount = amount)

        sourceAccount.amount = sourceAccount.amount.minus(amount)
        targetAccount.amount = targetAccount.amount.plus(exchangeResult)

        return accountRepository.save(account)
    }

    private fun verifyPesel(pesel: String) {
        PeselHelper.isAdult(pesel = pesel)
        accountRepository.findByPesel(pesel = pesel)?.let {
            throw IllegalStateException("Cannot duplicate pesel")
        }
    }

    fun getAccount(pesel: String): Account {
        return accountRepository.findByPesel(pesel = pesel)
            ?: throw NotFoundException("Account for pesel $pesel not found")
    }
}