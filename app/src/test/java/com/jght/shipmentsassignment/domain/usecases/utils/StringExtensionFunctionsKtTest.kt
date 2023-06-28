package com.jght.shipmentsassignment.domain.usecases.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StringExtensionFunctionsKtTest {

    @Test
    fun isEvenLength() {
        var text = "Osinski Manors"
        assertTrue(text.isEvenLength())

        text = "Kathlyn Ferry"
        assertFalse(text.isEvenLength())
    }

    @Test
    fun getVowelCount() {
        val text = "Osinski Manors"
        assertEquals(5, text.getVowelCount())
    }

    @Test
    fun getConsonantCount() {
        val text = "Kathlyn Ferry"
        assertEquals(10, text.getConsonantCount())
    }
}