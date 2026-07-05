package com.ctt.adminispmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ctt.adminispmobile.ui.theme.AdminISPMobileTheme
import com.ctt.adminispmobile.navigation.AppNavigation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctt.adminispmobile.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            AdminISPMobileTheme {

                val appViewModel: AppViewModel = viewModel()

                AppNavigation(
                    appViewModel = appViewModel
                )

            }

        }

    }

}