package com.jght.shipmentsassignment.framework.datasourceimpl.shipments.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonParser<T> {

    private val gson: Gson = Gson()

    fun parse(jsonContent: String, clazz: Class<T>): T {
        return gson.fromJson(jsonContent, clazz)
    }

    fun parseList(jsonContent: String): List<T> {
        val listType = object : TypeToken<List<T>>() {}.type
        return gson.fromJson(jsonContent, listType)
    }
}