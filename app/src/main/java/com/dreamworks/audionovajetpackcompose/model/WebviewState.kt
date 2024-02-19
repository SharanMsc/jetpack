package com.dreamworks.audionovajetpackcompose.model

import android.webkit.WebView
import com.dreamworks.audionovajetpackcompose.ui.utils.urlConst

data class WebViewState (
    var url: String = urlConst,
    var progress: Int = 0,
    var webView: WebView? = null
)