package com.dreamworks.audionovajetpackcompose.ui.screens.homeScreen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dreamworks.audionovajetpackcompose.R
import com.dreamworks.audionovajetpackcompose.navigation.MainScreens
import com.dreamworks.audionovajetpackcompose.ui.theme.colorPrimary
import com.dreamworks.audionovajetpackcompose.ui.theme.transparent
import com.dreamworks.audionovajetpackcompose.ui.utils.PreferencesManager

@Composable
fun HomeScreen(widthSizeClass: WindowSizeClass,navHostController: NavHostController) {
    when(widthSizeClass.widthSizeClass){
        WindowWidthSizeClass.Compact ->{

        }
        else->{

        }
    }

    val activity = (LocalContext.current as? Activity)

    BackHandler {
        activity!!.finish()
    }

    HomeScreenUI(navHostController)

}


@Composable
fun HomeScreenUI(navHostController: NavHostController) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val sendFlag = preferencesManager.getSendFlag()
    Box(modifier = Modifier
        .background(colorPrimary)
        .fillMaxSize()
        .padding(30.dp),
        contentAlignment = Alignment.Center


    ) {

        Column {
            Image(
                painter = painterResource(id = R.drawable.logo_small),
                contentDescription ="",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .background(transparent)
                    .clickable {
                        if(sendFlag){
                            navHostController.navigate(MainScreens.FormScreen.route)
                        }else{
                            navHostController.navigate(MainScreens.HearingTestScreen.route)
                        }

                    }
                ,
                contentAlignment = Alignment.Center

            ) {
                Column(modifier =
                Modifier.padding(vertical = 55.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hearing_exam),
                        contentDescription ="",
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = "Test dell'udito",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontFamily = FontFamily(
                            Font(R.font.myriadpro_semibold, FontWeight.Medium)
                        ),
                        modifier = Modifier.padding(top = 15.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .background(transparent)
                    .clickable {
                               navHostController.navigate(MainScreens.LoginScreen.route)
                    }
                ,
                contentAlignment = Alignment.Center

            ) {
                Column(modifier =
                Modifier.padding(vertical = 55.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription ="",
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = "Impostazioni",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontFamily = FontFamily(
                            Font(R.font.myriadpro_semibold, FontWeight.Medium)
                        ),
                        modifier = Modifier.padding(top = 15.dp)
                    )
                }
            }
        }

    }
}