package com.example.r2localapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.r2localapp.model.Job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailsScreen(job: Job) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(job.title) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Location: ${job.location}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Salary: ${job.salary}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Phone: ${job.phone}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Details: ${job.details}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
