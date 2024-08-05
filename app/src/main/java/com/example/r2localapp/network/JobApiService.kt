package com.example.r2localapp.network

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.r2localapp.model.Job

interface JobApiService {
    @GET("common/jobs")
    suspend fun getJobs(@Query("page") page: Int): List<Job>
}
