package com.sateeshjh.domain.di

import com.sateeshjh.domain.repository.BlogsRepository
import com.sateeshjh.domain.use_cases.GetBlogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetBlogUseCase(blogsRepository: BlogsRepository): GetBlogsUseCase {
        return GetBlogsUseCase(blogsRepository)
    }
}