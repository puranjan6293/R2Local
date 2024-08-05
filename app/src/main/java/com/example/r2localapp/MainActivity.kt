package com.example.r2localapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.r2localapp.ui.theme.MyAppTheme
import com.example.r2localapp.view.MainScreen
import com.example.r2localapp.viewmodel.JobViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val viewModel: JobViewModel = hiltViewModel()
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}
