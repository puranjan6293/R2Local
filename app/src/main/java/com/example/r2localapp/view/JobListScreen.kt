package com.example.r2localapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.r2localapp.model.Job
import com.example.r2localapp.viewmodel.JobViewModel

@Composable
fun JobListScreen(viewModel: JobViewModel, onJobClick: (Job) -> Unit) {
    val jobs by viewModel.jobs.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(false)
    val error by viewModel.error.observeAsState("")

    if (loading) {
        CircularProgressIndicator()
    } else if (error.isNotEmpty()) {
        Text(text = "Error: $error")
    } else if (jobs.isEmpty()) {
        Text(text = "No jobs available")
    } else {
        LazyColumn {
            items(jobs) { job ->
                JobCard(
                    job = job,
                    onJobClick = onJobClick,
                    onBookmarkClick = { viewModel.bookmarkJob(job) }
                )
            }
        }
    }
}
