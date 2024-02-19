package com.dreamworks.audionovajetpackcompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonHighlightAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.overlay.BalloonOverlayRoundRect
import com.dreamworks.audionovajetpackcompose.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun FormField(
    value: String,
    onValueChange: (String) -> Unit,
    onFocusChange: (FocusState) -> Unit,
    dark: Boolean,
    fieldFocused: Boolean,
    uiType: String,
    isLastField: Boolean,
    fieldType: String,
    color: Color,
    error: Boolean,


    ) {

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val imeAction = if (isLastField) ImeAction.Done else ImeAction.Next
    val keyboardType = when (fieldType) {
        "Number" -> {
            KeyboardType.Number
        }
        "Email" -> {
            KeyboardType.Email
        }
        "Phone" -> {
            KeyboardType.Phone
        }
        else -> {
            KeyboardType.Text
        }
    }
    val passwordVisible = remember { mutableStateOf(false) }


    val builder = rememberBalloonBuilder {
        setArrowSize(10)
        setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
        setArrowPosition(0.5f)
        setWidth(BalloonSizeSpec.WRAP)
        setHeight(BalloonSizeSpec.WRAP)
        setPadding(12)
        setCornerRadius(8f)
        setBackgroundColorResource(R.color.black)
        setBalloonAnimation(BalloonAnimation.ELASTIC)
        setIsVisibleOverlay(false)
        setOverlayColorResource(R.color.transparent)
        setOverlayPaddingResource(R.dimen.editBalloonOverlayPadding)
        setBalloonHighlightAnimation(BalloonHighlightAnimation.SHAKE)
        setOverlayShape(
            BalloonOverlayRoundRect(
                10f,
                10f
            )
        )
        setDismissWhenClicked(true)
    }


    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .padding(top = 5.dp)
            .onFocusChanged {
                onFocusChange(it)
            },
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(

            onNext = {
                if (!isLastField) {
                    focusManager.moveFocus(FocusDirection.Down)
                }

            },
            onDone = {
                if (isLastField) {
                    keyboardController?.hide()
                }

            }
        ),
        textStyle = TextStyle(color = if (dark) Color.White else Color.Black),
        singleLine = true,
        visualTransformation = if (fieldType == "Password") {
            if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        cursorBrush = Brush.verticalGradient(
            colors = listOf(color, color)
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    // margin left and right
                    .fillMaxWidth()

                    .border(
                        width = 1.dp,
                        color = if (dark) {
                            if (fieldFocused)
                                color else color
                        } else {
                            if (fieldFocused)
                                color else color
                        },
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(all = if (uiType == "Expand") 12.dp else 14.dp), // inner padding
                contentAlignment = Alignment.CenterStart
            ) {


                innerTextField()


                if (error) {
                    Balloon(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        builder = builder,
                        balloonContent = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Campo obbligatorio",
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                    ) { balloonWindow ->
                        balloonWindow.showAlignTop()
                        Icon(
                            painter = painterResource(id = R.drawable.error),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "",
                            tint = Color.Red


                        )
                        LaunchedEffect(key1 = true) {
                            delay(2000)
                            balloonWindow.dismiss()
                        }
                    }
                } else {
                    Box {

                    }
                }


            }
        }
    )

}