package com.dreamworks.audionovajetpackcompose.ui.screens.hearingTestScreen

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.dreamworks.audionovajetpackcompose.R
import com.dreamworks.audionovajetpackcompose.activity.MainActivityViewModel
import com.dreamworks.audionovajetpackcompose.model.WebViewState
import com.dreamworks.audionovajetpackcompose.navigation.MainScreens
import com.dreamworks.audionovajetpackcompose.ui.theme.colorPrimary
import com.dreamworks.audionovajetpackcompose.ui.utils.urlConst

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HearingTestScreen(navHostController: NavHostController, viewModel: MainActivityViewModel) {
    HearingTestScreenUI(navHostController,viewModel)
}

@SuppressLint("SetJavaScriptEnabled")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HearingTestScreenUI(navHostController: NavHostController, viewModel: MainActivityViewModel) {

   val context = LocalContext.current

    val webViewState by remember { mutableStateOf(WebViewState()) }
    var currentUrl by remember { mutableStateOf("") }

    BackHandler {
        if (webViewState.webView?.canGoBack() == true
            &&
            webViewState.url != currentUrl
        ) {
            webViewState.webView?.goBack()
        } else {
            navHostController.navigate(MainScreens.HomeScreen.route)
        }
    }

    viewModel.setCurrentScreen("HearingTestScreen")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Toast
                    .makeText(context, "Idle", Toast.LENGTH_LONG)
                    .show()
            }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(colorPrimary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_small),
                contentDescription = "",
                modifier = Modifier.padding(vertical = 50.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                AndroidView(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        Toast.makeText(context, "Idle", Toast.LENGTH_LONG).show()
                    }.fillMaxSize(),
                    factory = {
                        WebView(it).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                            settings.javaScriptEnabled = true
                            settings.cacheMode = WebSettings.LOAD_DEFAULT
                            settings.databaseEnabled = true
                            settings.domStorageEnabled = true
                            settings.useWideViewPort = true
                            settings.loadWithOverviewMode = true

                            webViewClient = WebViewClient()

                            webViewClient = object : WebViewClient() {
                                override fun onPageStarted(
                                    view: WebView?,
                                    url: String?,
                                    favicon: Bitmap?
                                ) {
                                    super.onPageStarted(view, url, favicon)

                                }

                                override fun onPageFinished(view: WebView?, url: String?) {
                                    super.onPageFinished(view, url)

                                }

                                override fun doUpdateVisitedHistory(
                                    view: WebView?,
                                    url: String?,
                                    isReload: Boolean
                                ) {
                                    super.doUpdateVisitedHistory(view, url, isReload)
                                    currentUrl = url!!

                                }
                            }


                            loadUrl(urlConst)
                        }
                    },
                    update = {
                        it.loadUrl(urlConst)
                        if (webViewState.url.isNotEmpty()) {
                            it.loadUrl(webViewState.url)
                        }

                        // Update WebView state
                        webViewState.webView = it



                    },
                )
            }
        }
    }


}