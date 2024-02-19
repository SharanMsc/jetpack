package com.dreamworks.audionovajetpackcompose.navigation

sealed class MainScreens(
    val route:String
){

    object SplashScreen:MainScreens(
        "SplashScreen"
    )
    object HomeScreen:MainScreens(
        "HomeScreen"
    )
    object FormScreen:MainScreens(
        "FormScreen"
    )
    object LoginScreen:MainScreens(
        "LoginScreen"
    )
    object SettingsScreen:MainScreens(
        "SettingsScreen"
    )
    object EmailScreen:MainScreens(
        "EmailScreen"
    )
    object HearingTestScreen:MainScreens(
        "HearingTestScreen"
    )

}
