package com.dreamworks.audionovajetpackcompose.ui.screens.settingsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dreamworks.audionovajetpackcompose.R
import com.dreamworks.audionovajetpackcompose.navigation.MainScreens
import com.dreamworks.audionovajetpackcompose.ui.components.FormField
import com.dreamworks.audionovajetpackcompose.ui.theme.colorPrimary
import com.dreamworks.audionovajetpackcompose.ui.utils.PreferencesManager

@Composable
fun SettingsScreen(navHostController: NavHostController) {
    SettingsScreenUI(navHostController)
}

@Composable
fun SettingsScreenUI(navHostController: NavHostController) {
    val settingsViewModel: SettingsScreenViewModel = viewModel()
    val codiceOperatoreError = settingsViewModel.codiceOperatoreError.observeAsState().value
    val codiceLocationError = settingsViewModel.codiceLocationError.observeAsState().value
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val dataSendFlag = remember { mutableStateOf(preferencesManager.getSendFlag()) }
    val opertatore = remember { mutableStateOf(preferencesManager.getOperatore())}
    val location = remember { mutableStateOf(preferencesManager.getLocation())}

    settingsViewModel.codiceOperatore.value = opertatore.value
    settingsViewModel.codiceLocation.value = location.value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .size(26.dp)
                    .align(Alignment.CenterStart)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_small),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .align(Alignment.Center)
            )

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                .background(Color.White)
                .padding(horizontal = 30.dp, vertical = 25.dp)
        ) {
            Text(
                text = "Codice operatore",
                color = colorPrimary,
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
            )
            FormField(
                value = opertatore.value!!,
                onValueChange = {

                    settingsViewModel.codiceOperatoreError.value = false
                    preferencesManager.storeOperatore(it)
                    opertatore.value = it
                },
                onFocusChange = {},
                dark = false,
                fieldFocused = false,
                uiType = "",
                isLastField = false,
                fieldType = "",
                color = Color(0xFFC9C9C9),
                error = codiceOperatoreError!!,

            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Codice location",
                color = colorPrimary,
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
            )
            FormField(
                value = location.value!!,
                onValueChange = {
                    settingsViewModel.codiceLocationError.value = false
                    preferencesManager.storeLocation(it)
                    location.value = it
                },
                onFocusChange = {},
                dark = false,
                fieldFocused = false,
                uiType = "",
                isLastField = true,
                fieldType = "",
                color = Color(0xFFC9C9C9),
                error = codiceLocationError!!,

            )
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Invia dati al CRM",
                    color = colorPrimary,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                )

                Switch(
                    checked = dataSendFlag.value,
                    onCheckedChange = {
                        preferencesManager.storeSend(it)
                        dataSendFlag.value = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedBorderColor = Color(0xff8DB656),
                        checkedTrackColor = colorPrimary,
                        uncheckedThumbColor = Color.White,
                        uncheckedBorderColor = Color(0xA3706F6F),
                        uncheckedTrackColor = Color(0xffB8B8B8)
                    ),
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterEnd)


                )
            }
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(45.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(colorPrimary)
                    .clickable {
                        if (settingsViewModel.validate()) {
                            navHostController.navigate(MainScreens.HomeScreen.route)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "SALVA",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                )
            }
        }

    }
}