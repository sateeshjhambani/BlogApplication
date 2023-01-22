package com.sateeshjh.data.repository

import com.sateeshjh.domain.model.Blog
import com.sateeshjh.domain.repository.BlogsRepository
import retrofit2.Response

class BlogsRepositoryImpl: BlogsRepository{

    // todo: remove nullable return type ?
    override suspend fun getBlogs(): Response<List<Blog>>? {
        return null
    }
}