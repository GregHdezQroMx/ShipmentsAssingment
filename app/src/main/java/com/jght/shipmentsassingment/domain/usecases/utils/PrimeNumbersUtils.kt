package com.jght.shipmentsassingment.domain.usecases.utils

fun getFirstPrimeCommonFactor(number1: Int, number2: Int): Int {
    var primeCommonFactor = 1
    var divisor = 2

    while (divisor <= number1 && divisor <= number2) {
        if (number1 % divisor == 0 && number2 % divisor == 0 && isPrime(divisor)) {
            primeCommonFactor = divisor
            break
        }
        divisor++
    }

    return primeCommonFactor
}

fun isPrime(number: Int): Boolean {
    if (number < 2) {
        return false
    }
    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

fun main() {
    val number1 = 9
    val number2 = 18
    val primeCommonFactor = getFirstPrimeCommonFactor(number1, number2)
    println("The first prime common factor between $number1 y $number2 is: $primeCommonFactor")
}
