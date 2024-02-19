package com.dreamworks.audionovajetpackcompose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dreamworks.audionovajetpackcompose.activity.MainActivityViewModel
import com.dreamworks.audionovajetpackcompose.ui.screens.emailScreen.EmailScreen
import com.dreamworks.audionovajetpackcompose.ui.screens.formScreen.FormScreen
import com.dreamworks.audionovajetpackcompose.ui.screens.hearingTestScreen.HearingTestScreen
import com.dreamworks.audionovajetpackcompose.ui.screens.homeScreen.HomeScreen
import com.dreamworks.audionovajetpackcompose.ui.screens.loginScreen.LoginScreen
import com.dreamworks.audionovajetpackcompose.ui.screens.settingsScreen.SettingsScreen
import com.dreamworks.audionovajetpackcompose.ui.screens.splashScreen.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreensNavHostController(
    navHostController: NavHostController,
    windowSize: WindowSizeClass,
    viewModel: MainActivityViewModel
){

    NavHost(navController = navHostController, startDestination = MainScreens.HomeScreen.route ){

        composable(route = MainScreens.SplashScreen.route){
            viewModel.setCurrentScreen(MainScreens.SplashScreen.route)
            SplashScreen(windowSize,navHostController)
        }
        composable(route = MainScreens.HomeScreen.route){
            viewModel.setCurrentScreen(MainScreens.HomeScreen.route)
            HomeScreen(windowSize,navHostController)
        }
        composable(route = MainScreens.FormScreen.route){
            viewModel.setCurrentScreen(MainScreens.FormScreen.route)
            FormScreen()
        }
        composable(route = MainScreens.LoginScreen.route){
            viewModel.setCurrentScreen(MainScreens.LoginScreen.route)
            LoginScreen(navHostController)
        }
        composable(route = MainScreens.SettingsScreen.route){
            viewModel.setCurrentScreen(MainScreens.SettingsScreen.route)
            SettingsScreen(navHostController)
        }
        composable(route =  MainScreens.EmailScreen.route){
            viewModel.setCurrentScreen(MainScreens.EmailScreen.route)
            EmailScreen()
        }
        composable(route =  MainScreens.HearingTestScreen.route){

            HearingTestScreen(navHostController,viewModel)
        }
    }
}