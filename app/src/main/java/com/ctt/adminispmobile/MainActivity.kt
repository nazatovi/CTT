package com.ctt.adminispmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ctt.adminispmobile.ui.theme.AdminISPMobileTheme
import com.ctt.adminispmobile.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            AdminISPMobileTheme {

                AppNavigation()

            }

        }

    }

}