package com.example.r2localapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.r2localapp.model.Job
import com.example.r2localapp.viewmodel.JobViewModel // Make sure to add this import

@Composable
fun BookmarkedJobsScreen(viewModel: JobViewModel, onJobClick: (Job) -> Unit) {
    val bookmarkedJobs by viewModel.bookmarkedJobs.observeAsState(emptyList())

    if (bookmarkedJobs.isEmpty()) {
        Text(text = "No bookmarked jobs")
    } else {
        LazyColumn {
            items(bookmarkedJobs) { bookmarkedJob ->
                val job = Job(
                    id = bookmarkedJob.id,
                    title = bookmarkedJob.title,
                    location = bookmarkedJob.location,
                    salary = bookmarkedJob.salary,
                    phone = bookmarkedJob.phone,
                    details = bookmarkedJob.details
                )
                JobCard(
                    job = job,
                    onJobClick = onJobClick,
                    onBookmarkClick = { viewModel.removeBookmark(job) }
                )
            }
        }
    }
}
