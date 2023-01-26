package com.sateeshjh.data.network.di

import android.content.Context
import com.sateeshjh.common.Constant
import com.sateeshjh.data.network.ApiService
import com.sateeshjh.data.repository.BlogsRepositoryImpl
import com.sateeshjh.data.room.BlogDAO
import com.sateeshjh.data.room.BlogDatabase
import com.sateeshjh.domain.repository.BlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
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

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BlogDatabase {
        return BlogDatabase.getInstance(context)
    }

    @Provides
    fun provideDAO(blogDatabase: BlogDatabase): BlogDAO {
        return blogDatabase.getBlogDAO()
    }
}