package com.jght.shipmentsassingment.domain.models

data class Shipment(
    val id: Int,
    val streetName: String,
    val city: String,
    val state: String,
    val zipCode: Int
)
