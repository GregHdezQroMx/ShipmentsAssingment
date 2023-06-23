package com.jght.shipmentsassingment.domain.models

sealed class ShipmentsDataSourceOrigin {
    object Local : ShipmentsDataSourceOrigin()
    object Remote : ShipmentsDataSourceOrigin()
}