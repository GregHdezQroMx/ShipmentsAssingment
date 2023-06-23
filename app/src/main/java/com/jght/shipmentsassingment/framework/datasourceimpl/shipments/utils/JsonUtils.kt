package com.jght.shipmentsassingment.framework.datasourceimpl.shipments.utils

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

fun readJSONFromAsset(context: Context, fileName: String): String {
    val stringBuilder = StringBuilder()
    try {
        val assetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))

        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }

        bufferedReader.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return stringBuilder.toString()
}
