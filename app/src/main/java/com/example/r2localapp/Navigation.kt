package com.example.r2localapp


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.r2localapp.view.BookmarkedJobsScreen
import com.example.r2localapp.view.JobDetailsScreen
import com.example.r2localapp.view.JobListScreen
import com.example.r2localapp.viewmodel.JobViewModel

@Composable
fun Navigation(navController: NavHostController, viewModel: JobViewModel, modifier: androidx.compose.ui.Modifier) {

    NavHost(navController = navController, startDestination = "jobs") {
        composable("jobs") {
            JobListScreen(viewModel) { job ->
                navController.navigate("jobDetails/${job.id}")
            }
        }
        composable("bookmarks") {
            BookmarkedJobsScreen(viewModel) { job ->
                navController.navigate("jobDetails/${job.id}")
            }
        }
        composable("jobDetails/{jobId}") { backStackEntry ->
            val jobId = backStackEntry.arguments?.getInt("jobId") ?: return@composable
            val job = viewModel.jobs.value?.find { it.id == jobId }
            if (job != null) {
                JobDetailsScreen(job)
            } else {
                Text("Job not found")
            }
        }
    }
}
