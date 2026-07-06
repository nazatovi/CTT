package com.ctt.adminispmobile.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast

object CopyUtils {

    fun copy(
        context: Context,
        label: String,
        value: String
    ) {

        val clipboard =
            context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as ClipboardManager

        clipboard.setPrimaryClip(
            ClipData.newPlainText(
                label,
                value
            )
        )

        Toast.makeText(
            context,
            "$label copiado",
            Toast.LENGTH_SHORT
        ).show()

    }

}