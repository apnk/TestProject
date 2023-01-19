package com.test.project.testproject.logic.helper

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PeselHelperTest {

    @Test
    fun checkAgeChecker() {
        Assertions.assertTrue(PeselHelper.isAdult("55032471735"))
        Assertions.assertFalse(PeselHelper.isAdult("20230222399"))
        Assertions.assertFalse(PeselHelper.isAdult("95230255245"))

        Assertions.assertThrows(IllegalStateException::class.java) {
            PeselHelper.isAdult("00430281325")
        }.message.equals("Client should be born between 1900 and 2099")
    }


}