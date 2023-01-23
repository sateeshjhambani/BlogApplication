package com.sateeshjh.data.network.di

import com.sateeshjh.data.network.ApiService
import com.sateeshjh.data.repository.BlogsRepositoryImpl
import com.sateeshjh.domain.repository.BlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideBlogRepository(apiService: ApiService): BlogsRepository {
        return BlogsRepositoryImpl(apiService)
    }
}