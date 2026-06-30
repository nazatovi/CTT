package com.ctt.adminispmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ctt.adminispmobile.ui.login.LoginScreen
import com.ctt.adminispmobile.ui.theme.AdminISPMobileTheme
import com.ctt.adminispmobile.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            AdminISPMobileTheme {

                val loginViewModel: LoginViewModel = viewModel()

                LoginScreen(
                    viewModel = loginViewModel
                )

            }

        }

    }

}