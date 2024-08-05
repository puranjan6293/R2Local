package com.example.r2localapp.di

import android.content.Context
import com.example.r2localapp.network.JobApiService
import com.example.r2localapp.network.RetrofitInstance
import com.example.r2localapp.repository.JobRepository
import com.example.r2localapp.model.JobDatabase
import com.example.r2localapp.model.BookmarkedJobDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJobApiService(): JobApiService {
        return RetrofitInstance.api
    }

    @Provides
    @Singleton
    fun provideBookmarkedJobDao(database: JobDatabase): BookmarkedJobDao {
        return database.bookmarkedJobDao()
    }

    @Provides
    @Singleton
    fun provideJobDatabase(@ApplicationContext appContext: Context): JobDatabase {
        return JobDatabase.getDatabase(appContext)
    }

    @Provides
    @Singleton
    fun provideJobRepository(
        jobApiService: JobApiService,
        bookmarkedJobDao: BookmarkedJobDao
    ): JobRepository {
        return JobRepository(jobApiService, bookmarkedJobDao)
    }
}
