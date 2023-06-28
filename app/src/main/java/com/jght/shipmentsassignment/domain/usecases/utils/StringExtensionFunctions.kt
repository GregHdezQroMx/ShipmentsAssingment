package com.jght.shipmentsassignment.domain.usecases.utils

fun String.isEvenLength(): Boolean {
    return this.length % 2 == 0
}

fun String.getVowelCount(): Int {
    val vowelsRegex = Regex("[aeiou]", RegexOption.IGNORE_CASE)
    return count { vowelsRegex.matches(it.toString()) }
}

fun String.getConsonantCount(): Int {
    val consonantsRegex = Regex("[b-df-hj-np-tv-z]", RegexOption.IGNORE_CASE)
    return count { consonantsRegex.matches(it.toString()) }
}

/*
fun main() {
    val text = "Hello MY frien"
    println(text.isEvenLength())
    println(text.getVowelCount())
    println(text.getConsonantCount())
}*/

