package com.jght.shipmentsassignment.domain.models

sealed class ShipmentsDataSourceOrigin {
    object Local : ShipmentsDataSourceOrigin()
    object Remote : ShipmentsDataSourceOrigin()
}