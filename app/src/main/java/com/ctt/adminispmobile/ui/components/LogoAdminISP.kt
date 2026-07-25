package com.ctt.adminispmobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.ctt.adminispmobile.R

@Composable
fun LogoAdminISP(

    modifier: Modifier = Modifier

) {

    Image(

        painter = painterResource(R.drawable.logo_adminisp),

        contentDescription = "Logo AdminISP Mobile",

        modifier = modifier,

        contentScale = ContentScale.Fit

    )

}