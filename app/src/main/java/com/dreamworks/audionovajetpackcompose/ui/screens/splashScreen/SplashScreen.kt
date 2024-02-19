package com.dreamworks.audionovajetpackcompose.ui.screens.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.dreamworks.audionovajetpackcompose.R
import com.dreamworks.audionovajetpackcompose.navigation.MainScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(windowSize: WindowSizeClass,navHostController: NavHostController) {
//    when(windowSize.widthSizeClass){
//        WindowWidthSizeClass.Compact ->{
//
//        }
//        else->{
//
//        }
//    }

    SplashScreenUI()
    LaunchedEffect(key1 =true){
        delay(1000)
        navHostController.navigate(MainScreens.HomeScreen.route)
    }


}

@Preview
@Composable
fun SplashScreenUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg),
                contentScale = ContentScale.FillBounds
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_small),
            contentDescription = ""
        )
    }
}