package com.example.r2localapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.r2localapp.model.Job
import com.example.r2localapp.model.BookmarkedJob
import com.example.r2localapp.repository.JobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {

    private val _jobs = MutableLiveData<List<Job>>()
    val jobs: LiveData<List<Job>> = _jobs

    private val _bookmarkedJobs = MutableLiveData<List<BookmarkedJob>>()
    val bookmarkedJobs: LiveData<List<BookmarkedJob>> = _bookmarkedJobs

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    init {
        loadJobs()
        loadBookmarkedJobs()
    }

    private fun loadJobs() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val jobs = repository.getJobs(1)
                _jobs.value = jobs
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    private fun loadBookmarkedJobs() {
        viewModelScope.launch {
            try {
                val bookmarkedJobs = repository.getBookmarkedJobs()
                _bookmarkedJobs.value = bookmarkedJobs
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun bookmarkJob(job: Job) {
        viewModelScope.launch {
            repository.bookmarkJob(BookmarkedJob(job.id, job.title, job.location, job.salary, job.phone, job.details))
            loadBookmarkedJobs()
        }
    }

    fun removeBookmark(job: Job) {
        viewModelScope.launch {
            repository.removeBookmark(BookmarkedJob(job.id, job.title, job.location, job.salary, job.phone, job.details))
            loadBookmarkedJobs()
        }
    }
}
