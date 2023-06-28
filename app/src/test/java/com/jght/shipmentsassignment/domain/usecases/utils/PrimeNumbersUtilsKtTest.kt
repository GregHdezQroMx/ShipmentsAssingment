package com.jght.shipmentsassignment.domain.usecases.utils

import org.junit.Assert.*

import org.junit.Test

class PrimeNumbersUtilsKtTest {

    @Test
    fun getFirstPrimeCommonFactor() {
        var number1 = 9
        var number2 = 18
        var primeCommonFactor =
            getFirstPrimeCommonFactor(
                number1,
                number2
            )
        assertEquals(3, primeCommonFactor)

        number1 = 5
        number2 = 24
        primeCommonFactor =
            getFirstPrimeCommonFactor(
                number1,
                number2
            )
        assertEquals(1, primeCommonFactor)

        number1 = 8
        number2 = 24
        primeCommonFactor =
            getFirstPrimeCommonFactor(
                number1,
                number2
            )
        assertEquals(2, primeCommonFactor)
    }

    @Test
    fun isPrime() {
        assertTrue(isPrime(2))
        assertTrue(isPrime(3))
        assertTrue(isPrime(5))
        assertTrue(isPrime(7))
        assertFalse(isPrime(8))
        assertTrue(isPrime(11))
        assertTrue(isPrime(13))
        assertFalse(isPrime(15))
    }
}