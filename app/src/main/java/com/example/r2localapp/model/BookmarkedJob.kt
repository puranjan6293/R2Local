package com.example.r2localapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked_jobs")
data class BookmarkedJob(
    @PrimaryKey val id: Int,
    val title: String,
    val location: String,
    val salary: String,
    val phone: String,
    val details: String
)
