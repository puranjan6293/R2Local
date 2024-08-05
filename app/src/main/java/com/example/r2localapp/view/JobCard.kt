package com.example.r2localapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.r2localapp.model.Job

@Composable
fun JobCard(job: Job, onJobClick: (Job) -> Unit, onBookmarkClick: (Job) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onJobClick(job) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = job.title, style = MaterialTheme.typography.headlineLarge)
            Text(text = job.location, style = MaterialTheme.typography.bodyMedium)
            Text(text = job.salary, style = MaterialTheme.typography.bodyMedium)
            Text(text = job.phone, style = MaterialTheme.typography.bodyMedium)
            IconButton(onClick = { onBookmarkClick(job) }) {
                Icon(Icons.Default.Check, contentDescription = "Bookmark")
            }
        }
    }
}
