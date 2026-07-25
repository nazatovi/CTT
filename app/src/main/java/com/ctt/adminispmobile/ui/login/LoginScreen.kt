package com.ctt.adminispmobile.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ctt.adminispmobile.ui.components.AdminCard
import com.ctt.adminispmobile.viewmodel.LoginViewModel
import com.ctt.adminispmobile.ui.components.LogoAdminISP

@Composable
fun LoginScreen(

    viewModel: LoginViewModel,

    onLoginSuccess: () -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    var passwordVisible by remember {

        mutableStateOf(false)

    }

    Box(

        modifier = Modifier.fillMaxSize()

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center

        ) {

            LogoAdminISP()

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "AdminISP Mobile",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Sistema de Administración ISP",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(

                text = "Cooperativa Telefónica Tostado",

                style = MaterialTheme.typography.bodyMedium,

                color = MaterialTheme.colorScheme.primary

            )

            Spacer(modifier = Modifier.height(28.dp))

            AdminCard {

                OutlinedTextField(

                    value = uiState.usuario,

                    onValueChange = viewModel::setUsuario,

                    label = {

                        Text("Usuario")

                    },

                    leadingIcon = {

                        Icon(
                            Icons.Default.Person,
                            null
                        )

                    },

                    singleLine = true,

                    modifier = Modifier.fillMaxWidth()

                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(

                    value = uiState.password,

                    onValueChange = viewModel::setPassword,

                    label = {

                        Text("Contraseña")

                    },

                    leadingIcon = {

                        Icon(
                            Icons.Default.Lock,
                            null
                        )

                    },

                    trailingIcon = {

                        IconButton(

                            onClick = {

                                passwordVisible =
                                    !passwordVisible

                            }

                        ) {

                            Icon(

                                imageVector =
                                    if (passwordVisible)
                                        Icons.Default.VisibilityOff
                                    else
                                        Icons.Default.Visibility,

                                contentDescription = null

                            )

                        }

                    },

                    visualTransformation =

                        if (passwordVisible)

                            VisualTransformation.None

                        else

                            PasswordVisualTransformation(),

                    singleLine = true,

                    modifier = Modifier.fillMaxWidth()

                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(

                    onClick = {

                        viewModel.login()

                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)

                ) {

                    if (uiState.loading) {

                        CircularProgressIndicator(

                            strokeWidth = 2.dp

                        )

                    } else {

                        Text(

                            "INGRESAR"

                        )

                    }

                }

            }

            uiState.error?.let {

                Spacer(modifier = Modifier.height(20.dp))

                Text(

                    text = it,

                    color = MaterialTheme.colorScheme.error

                )

            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(

                text = "Versión 1.0",

                style = MaterialTheme.typography.labelMedium,

                color = MaterialTheme.colorScheme.outline

            )

        }

    }

    LaunchedEffect(uiState.success) {

        if (uiState.success) {

            onLoginSuccess()

        }

    }

}