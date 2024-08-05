package com.example.r2localapp.repository

import com.example.r2localapp.network.JobApiService
import com.example.r2localapp.model.BookmarkedJob
import com.example.r2localapp.model.BookmarkedJobDao
import com.example.r2localapp.model.Job

class JobRepository(
    private val jobApiService: JobApiService,
    private val bookmarkedJobDao: BookmarkedJobDao
) {

    suspend fun getJobs(page: Int): List<Job> {
        return jobApiService.getJobs(page)
    }

    suspend fun getBookmarkedJobs(): List<BookmarkedJob> {
        return bookmarkedJobDao.getAllBookmarkedJobs()
    }

    suspend fun bookmarkJob(job: BookmarkedJob) {
        bookmarkedJobDao.insert(job)
    }

    suspend fun removeBookmark(job: BookmarkedJob) {
        bookmarkedJobDao.delete(job)
    }
}
