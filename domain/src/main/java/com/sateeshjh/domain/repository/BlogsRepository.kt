package com.sateeshjh.domain.repository

import com.sateeshjh.domain.model.Blog
import retrofit2.Response

interface BlogsRepository {

    suspend fun getBlogs(): List<Blog>
}