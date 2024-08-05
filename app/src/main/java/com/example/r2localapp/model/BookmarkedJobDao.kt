package com.example.r2localapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookmarkedJobDao {

    @Query("SELECT * FROM bookmarked_jobs")
    suspend fun getAllBookmarkedJobs(): List<BookmarkedJob>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(job: BookmarkedJob)

    @Delete
    suspend fun delete(job: BookmarkedJob)
}
