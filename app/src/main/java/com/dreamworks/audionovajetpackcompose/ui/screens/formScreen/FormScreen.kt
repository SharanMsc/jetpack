package com.dreamworks.audionovajetpackcompose.ui.screens.formScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dreamworks.audionovajetpackcompose.R
import com.dreamworks.audionovajetpackcompose.ui.components.FormField
import com.dreamworks.audionovajetpackcompose.ui.theme.colorPrimary

@Composable
fun FormScreen() {
    FormScreenUI()
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FormScreenUI() {

    val formViewModel: FormScreenViewModel = viewModel()
    val nomeField = formViewModel.nomeField.observeAsState().value
    val cogNomeField = formViewModel.cogNomeField.observeAsState().value
    val telePhoneField = formViewModel.telePhoneField.observeAsState().value
    val emailField = formViewModel.emailField.observeAsState().value
    val capField = formViewModel.capField.observeAsState().value
    val policy = formViewModel.policy.observeAsState().value


    val nomeFieldError = formViewModel.nomeFieldError.observeAsState().value
    val cogNomeFieldError = formViewModel.cogNomeFieldError.observeAsState().value
    val telePhoneFieldError = formViewModel.telePhoneFieldError.observeAsState().value
    val emailFieldError = formViewModel.emailFieldError.observeAsState().value
    val capFieldError = formViewModel.capFieldError.observeAsState().value
    val policyError = formViewModel.policyError.observeAsState().value

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

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .imePadding()
            ) {
                item {
                    Text(
                        text = "Nome",
                        color = colorPrimary,
                        fontSize = 17.sp,
                        fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                    )
                    FormField(
                        value = nomeField!!,
                        onValueChange = {
                            formViewModel.nomeField.value = it
                            formViewModel.nomeFieldError.value = false
                        },
                        onFocusChange = {},
                        dark = false,
                        fieldFocused = false,
                        uiType = "",
                        isLastField = false,
                        fieldType = "",
                        color = Color(0xFFC9C9C9),
                        error = nomeFieldError!!,

                        )
                    Text(
                        text = "Cognome",
                        color = colorPrimary,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(top = 60.dp),
                        fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                    )
                    FormField(
                        value = cogNomeField!!,
                        onValueChange = {
                            formViewModel.cogNomeField.value = it
                            formViewModel.cogNomeFieldError.value = false
                        },
                        onFocusChange = {},
                        dark = false,
                        fieldFocused = false,
                        uiType = "",
                        isLastField = false,
                        fieldType = "",
                        color = Color(0xFFC9C9C9),
                        error = cogNomeFieldError!!,

                        )
                    Text(
                        text = "Telefono",
                        color = colorPrimary,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(top = 60.dp),
                        fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                    )
                    FormField(
                        value = telePhoneField!!,
                        onValueChange = {
                            formViewModel.telePhoneField.value = it
                            formViewModel.telePhoneFieldError.value = false
                        },
                        onFocusChange = {},
                        dark = false,
                        fieldFocused = false,
                        uiType = "",
                        isLastField = false,
                        fieldType = "Phone",
                        color = Color(0xFFC9C9C9),
                        error = telePhoneFieldError!!,

                        )
                    Text(
                        text = "Email",
                        color = colorPrimary,
                        fontSize = 17.sp,
                        fontFamily = FontFamily(Font(R.font.myriadpro_semibold)),
                        modifier = Modifier.padding(top = 60.dp)
                    )
                    FormField(
                        value = emailField!!,
                        onValueChange = {
                            formViewModel.emailField.value = it
                            formViewModel.emailFieldError.value = false
                        },
                        onFocusChange = {},
                        dark = false,
                        fieldFocused = false,
                        uiType = "",
                        isLastField = false,
                        fieldType = "Email",
                        color = Color(0xFFC9C9C9),
                        error = emailFieldError!!,

                        )
                    Text(
                        text = "CAP",
                        color = colorPrimary,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(top = 60.dp),
                        fontFamily = FontFamily(Font(R.font.myriadpro_semibold))
                    )
                    FormField(
                        value = capField!!,
                        onValueChange = {
                            formViewModel.capField.value = it
                            formViewModel.capFieldError.value = false
                        },
                        onFocusChange = {},
                        dark = false,
                        fieldFocused = false,
                        uiType = "",
                        isLastField = true,
                        fieldType = "Number",
                        color = Color(0xFFC9C9C9),
                        error = capFieldError!!,

                        )
                    Row(
                        modifier = Modifier.padding(top = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                            Checkbox(
                                checked = policy!!,
                                onCheckedChange = {

                                    formViewModel.policy.value = it
                                },

                                )
                        }
                        Text(
                            text = "Acconsento al trattamento dei dati come riportato nella Privacy Policy",
                            color = Color.Black,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(start = 10.dp),
                            fontFamily = FontFamily(Font(R.font.myriadpro_regular))
                        )
                    }


                }


            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()

                    .background(Color.White)

            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .height(45.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(colorPrimary)
                        .clickable {
                            formViewModel.validate()
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
}