package com.dreamworks.audionovajetpackcompose.ui.screens.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.dreamworks.audionovajetpackcompose.ui.theme.transparent

@Composable
fun LoginScreen(navHostController: NavHostController) {
    LoginScreenUI(navHostController)
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreenUI(navHostController: NavHostController) {
    val loginViewModel: LoginScreenViewModel = viewModel()
    val username = loginViewModel.userName.observeAsState().value
    val password = loginViewModel.password.observeAsState().value
    val usernameFocused = loginViewModel.userNameFocused.observeAsState().value
    val passwordFocused = loginViewModel.passwordFocused.observeAsState().value
    val usernameError = loginViewModel.userNameError.observeAsState().value
    val passwordError = loginViewModel.userPasswordError.observeAsState().value
    val (usernameFocusRequester) = FocusRequester.createRefs()
    val (passwordFocusRequester) = FocusRequester.createRefs()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg),
                contentScale = ContentScale.FillBounds
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.logo_small
                ),
                contentDescription = "",

                )
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 30.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(transparent)
                    .padding(30.dp)
            ) {
                Text(
                    text = "Nome",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                )
                FormField(
                    value = username!!,
                    onValueChange = {
                        loginViewModel.userName.value = it
                        loginViewModel.userNameError.value = false
                    },
                    onFocusChange = {
                        loginViewModel.userNameFocused.value = true
                        loginViewModel.passwordFocused.value = false
                    },
                    dark = true,
                    fieldFocused = usernameFocused!!,
                    uiType = "",
                    isLastField = false,
                    fieldType = "",
                    color = Color(0xffffffff),
                    error = usernameError!!,


                )
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Password",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                )
                FormField(
                    value = password!!,
                    onValueChange = {
                        loginViewModel.password.value = it
                        loginViewModel.userPasswordError.value = false
                    },
                    onFocusChange = {
                        loginViewModel.userNameFocused.value = false
                        loginViewModel.passwordFocused.value = true
                    },
                    dark = true,
                    fieldFocused = passwordFocused!!,
                    uiType = "",
                    isLastField = true,
                    fieldType = "Password",
                    color = Color(0xffffffff),
                    error = passwordError!!,

                )

                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .height(45.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .clickable {
                            if (loginViewModel.validate()) {
                                navHostController.navigate(MainScreens.SettingsScreen.route)
                            }


                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "LOGIN",
                        color = colorPrimary,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                    )
                }
            }
        }

    }
}