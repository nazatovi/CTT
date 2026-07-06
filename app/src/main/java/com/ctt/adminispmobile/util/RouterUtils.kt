package com.ctt.adminispmobile.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

object RouterUtils {

    fun open(
        context: Context,
        ip: String
    ) {

        Log.d("ROUTER", "Intentando abrir: $ip")

        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://${ip}:8080")
        )

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        Log.d("ROUTER", "Abriendo $ip")

        context.startActivity(intent)

    }

}