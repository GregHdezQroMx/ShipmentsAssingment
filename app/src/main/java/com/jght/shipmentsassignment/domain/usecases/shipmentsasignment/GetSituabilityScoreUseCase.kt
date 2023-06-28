package com.jght.shipmentsassignment.domain.usecases.shipmentsasignment

import com.jght.shipmentsassignment.domain.usecases.utils.getConsonantCount
import com.jght.shipmentsassignment.domain.usecases.utils.getFirstPrimeCommonFactor
import com.jght.shipmentsassignment.domain.usecases.utils.getVowelCount
import com.jght.shipmentsassignment.domain.usecases.utils.isEvenLength

class GetSuitabilityScoreUseCase {

    operator fun invoke(streetName: String, driverName: String): Float {
        return getSuitabilityScore(text1 = streetName, text2 = driverName)
    }

    private fun getSuitabilityScore(text1: String, text2: String): Float {

        val suitabilityScore = getPreliminarySuitabilityScore(text1)

        return if (getFirstPrimeCommonFactor(text1.length, text2.length) > 1) {
            suitabilityScore * 1.5F
        } else {
            suitabilityScore
        }
    }

    private fun getPreliminarySuitabilityScore(text: String): Float {
        return if (text.isEvenLength()){
            text.getVowelCount() * 1.5F
        } else {
            text.getConsonantCount() * 1.0F
        }
    }
}

