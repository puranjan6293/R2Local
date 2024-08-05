package com.example.r2localapp.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.r2localapp.viewmodel.JobViewModel
import com.example.r2localapp.Navigation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainScreen(viewModel: JobViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        Navigation(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Jobs") },
            label = { Text("Jobs") },
            selected = currentRoute == "jobs",
            onClick = { navController.navigate("jobs") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Check, contentDescription = "Bookmarks") },
            label = { Text("Bookmarks") },
            selected = currentRoute == "bookmarks",
            onClick = { navController.navigate("bookmarks") }
        )
    }
}
