package com.test.project.testproject.logic.helper

import java.time.LocalDate


class PeselHelper {
    companion object {

        fun isAdult(pesel: String): Boolean {
            val birthYear = LocalDate.of(getYear(pesel), getMonth(pesel), getDay(pesel))
            val now = LocalDate.now()
            return now.minusYears(birthYear.year.toLong()).minusMonths(birthYear.month.value.toLong())
                .minusDays(birthYear.dayOfMonth.toLong()).year >= 18
        }

        fun getYear(pesel: String): Int {
            var year: Int = 10 * pesel[0].digitToInt() + pesel[1].digitToInt()
            val month: Int = 10 * pesel[2].digitToInt() + pesel[3].digitToInt()
            when (month) {
                in 1..12 -> {
                    year += 1900
                }

                in 21..32 -> {
                    year += 2000
                }

                else -> {
                    throw IllegalStateException("Client should be born between 1900 and 2099")
                }
            }
            return year
        }

        fun getMonth(pesel: String): Int {
            var month = 10 * pesel[2].digitToInt() + pesel[3].digitToInt()
            if (month in 81..92) {
                month -= 80
            } else if (month in 21..32) {
                month -= 20
            } else if (month in 41..52) {
                month -= 40
            } else if (month in 61..72) {
                month -= 60
            }
            return month
        }


        fun getDay(pesel: String): Int {
            return 10 * pesel[4].digitToInt() + pesel[5].digitToInt()
        }


    }


}