package com.ctt.adminispmobile.util

import kotlin.math.ln
import kotlin.math.pow

object FormatUtils {

    fun bytesToHuman(bytes: Double): String {

        if (bytes <= 0) return "0 B"

        val units = listOf(
            "B",
            "KB",
            "MB",
            "GB",
            "TB"
        )

        val digitGroups =
            (ln(bytes) / ln(1024.0)).toInt()

        return String.format(

            "%.2f %s",

            bytes / 1024.0.pow(digitGroups.toDouble()),

            units[digitGroups]

        )

    }

}