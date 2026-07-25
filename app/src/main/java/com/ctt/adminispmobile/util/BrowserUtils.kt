package com.ctt.adminispmobile.util

import android.content.Context
import android.content.Intent
import android.net.Uri

object BrowserUtils {

    fun openEquipment(
        context: Context,
        ip: String,
        port: Int
    ) {

        val url = "http://$ip:$port"

        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )

        context.startActivity(intent)

    }

}