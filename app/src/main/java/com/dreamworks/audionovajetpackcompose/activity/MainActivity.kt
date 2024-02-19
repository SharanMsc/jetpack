package com.dreamworks.audionovajetpackcompose.activity

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.dreamworks.audionovajetpackcompose.navigation.MainScreensNavHostController
import com.dreamworks.audionovajetpackcompose.ui.theme.AudionovaJetpackComposeTheme

class MainActivity : ComponentActivity() {

    private val activityViewModel:MainActivityViewModel by viewModels()
    private var count=0

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudionovaJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    val windowSize = calculateWindowSizeClass(activity = this)
                    val viewModel:MainActivityViewModel = viewModel()
                    MainScreensNavHostController(navHostController = navHostController,windowSize=windowSize,viewModel)
                    val currentScreen = navHostController.currentBackStackEntry?.destination?.route ?: ""
                    viewModel.currentScreen.value = currentScreen
                    // Display the current screen in the logcat


                }
            }
        }

        activityViewModel.currentScreen.observe(this){
            if(it=="HearingTestScreen"){
                count++
                if (count==1){
                    Toast
                        .makeText(this, "HearingTestScreen", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AudionovaJetpackComposeTheme {
        Greeting("Android")
    }
}